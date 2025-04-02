package likhit.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import likhit.quizapp.QuizappApplication;
import likhit.quizapp.dao.QuestionsDao;
import likhit.quizapp.dao.QuizDao;
import likhit.quizapp.exception.QuizIdNotFoundException;
import likhit.quizapp.model.QuestionWrapper;
import likhit.quizapp.model.Quiz;
import likhit.quizapp.model.Quizquestions;
import likhit.quizapp.model.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizrepo;
	@Autowired
	QuestionsDao questionsdao;

	public ResponseEntity<String> createQuiz(String catogery, int questions, String title) {
		List<Quizquestions> Q = questionsdao.findRandomQuestionsByCatogery(catogery, questions);
		Quiz quiz = new Quiz();
		quiz.setQuestions(Q);
		quiz.setTitle("Catogery Quiz");
		quizrepo.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	public List<Quiz> getAllQuiz() {
		return quizrepo.findAll();
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> questions = quizrepo.findById(id);
		List<QuestionWrapper> wrapper = new ArrayList<QuestionWrapper>();
		if (questions.isEmpty()) {
			throw new QuizIdNotFoundException("Id not found Please verify teh id");
		} 
		else {
			List<Quizquestions> quizQs = questions.get().getQuestions();
			for (Quizquestions q : quizQs) {
				wrapper.add(new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
						q.getOption3(), q.getOption4()));
			}
		}
		return new ResponseEntity<>(wrapper,HttpStatus.OK);   
	}

	public ResponseEntity<Integer> getSubmit(int id, List<Response> response) {
		Quiz quiz = quizrepo.findById(id).get();
		System.out.println("Questions:" + quiz);
		List<Quizquestions> questions = quiz.getQuestions();
		int i = 0, right = 0;
		for (Response res : response) {
			if (res.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}

			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
