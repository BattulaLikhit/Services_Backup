package likhit.quizapp.exception;

import java.net.http.HttpRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import likhit.quizapp.model.ApiException;

@RestControllerAdvice
public class ApplicationExceptionHandler {   
	@ExceptionHandler(QuizIdNotFoundException.class)
	public ResponseEntity<?> quizNotFoundException(QuizIdNotFoundException ex,HttpServletRequest request){
    	      ApiException api=new ApiException(ex.getMessage(),request.getRequestURI());
    	      return new ResponseEntity<>(api,HttpStatus.NOT_FOUND);
       }
}
