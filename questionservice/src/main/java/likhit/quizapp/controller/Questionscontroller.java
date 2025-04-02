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
import org.springframework.web.bind.annotation.RestController;

import likhit.quizapp.model.Quizquestions;
import likhit.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class Questionscontroller {
	@Autowired
	QuestionService service;
	@GetMapping("/getAllquestions")
	public ResponseEntity<List<Quizquestions>> getAllquestions(){
		 if(service.getAllquestions()!=null) {
			 return new ResponseEntity<>(service.getAllquestions(),HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>(new ArrayList(),HttpStatus.BAD_REQUEST);
		 }
	}
	@PostMapping("/uploadquestion")
	public void uploadquestions(@RequestBody List<Quizquestions> question) {
		for(Quizquestions q:question ) {
			   service.uploadquestions(q);
		}
		
	}
	@GetMapping("/getQuestionsbycatogery/{catogery}/{questions}")
	public List<Quizquestions> getQuestionsbyCatogery(@PathVariable String catogery,@PathVariable int questions) {
		return service.getQuestionsByCatogery(catogery,questions);
	}

}
