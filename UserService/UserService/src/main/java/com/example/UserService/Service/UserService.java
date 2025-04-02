package com.example.UserService.Service;

import java.util.List;
import java.util.Optional;

import com.example.UserService.Model.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
	User getusername(String username);
//	public String authentication(User user);
	public User findByUserName(String username);
}