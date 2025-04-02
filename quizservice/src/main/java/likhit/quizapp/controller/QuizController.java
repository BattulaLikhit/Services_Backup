 package likhit.quizapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import likhit.quizapp.model.QuestionWrapper;
import likhit.quizapp.model.Quiz;
import likhit.quizapp.model.Quizquestions;
import likhit.quizapp.model.Response;
import likhit.quizapp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> postTheQuestions(@RequestParam String catogery,@RequestParam int questions,@RequestParam String title){
		
		return service.createQuiz(catogery,questions,title);
	}
	@GetMapping("/getAllQuiz")
	public List<Quiz> getAllQuiz(){
		return service.getAllQuiz();
	}
	@GetMapping("/getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
		 return service.getQuizQuestions(id);
		
	}
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> getSubmit(@PathVariable int id,@RequestBody List<Response> response){
		return service.getSubmit(id,response);
	}

}