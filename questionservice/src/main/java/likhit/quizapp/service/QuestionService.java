package likhit.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import likhit.quizapp.dao.QuestionsDao;
import likhit.quizapp.model.Quizquestions;

@Service
public class QuestionService {
	@Autowired
	QuestionsDao repo;

	public List<Quizquestions> getAllquestions() {
		return repo.findAll();

	}

	public void uploadquestions(Quizquestions q) {
		  repo.save(q);
	}

	public List<Quizquestions> getQuestionsByCatogery(String catogery,int questions) {
		   return repo.findRandomQuestionsByCatogery(catogery,questions);
	}
}
