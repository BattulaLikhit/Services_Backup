package com.example.UserService.Exceptions;

public class UserAlreadyExists extends RuntimeException{
	public UserAlreadyExists(String message) {
		super(message);
	}

}
