package com.example.CourseService.Exceptions;

public class CourseIdNotFoundException extends RuntimeException{
	public CourseIdNotFoundException(String message) {
		super(message);
	}

}
