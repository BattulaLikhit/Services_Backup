package com.example.CourseService.Exceptions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)   //its thrown by the @Valid annotation
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<FieldError> listOfErrors = ex.getFieldErrors();
		for (FieldError err : listOfErrors) {
			sb.append("Error in Field: ").append(err.getField()).append(" -> ").append(err.getDefaultMessage()).append(" ------- ");
		}
		ApiException api = new ApiException(sb.toString(), request.getRequestURI(), LocalDateTime.now());
		return new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handlerNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {
		ApiException api = new ApiException(request.getRequestURI(), ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceIdNotFoundException.class)
	public ResponseEntity<?> resourceIdNotFoundException(ResourceIdNotFoundException ex, HttpServletRequest request) {
		ApiException api = new ApiException(request.getRequestURI(), ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
	}
	
}
