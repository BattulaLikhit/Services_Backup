package com.example.UserService.Service;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UserService.Exceptions.UserAlreadyExists;
import com.example.UserService.Exceptions.UserNotFoundException;
import com.example.UserService.Model.User;
import com.example.UserService.Repo.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private UserRepo userRepository;

//	@Autowired    
//	private EmailServiceImpl emailserviceimpl;   // Email Service

//	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	@Override
	public List<User> getAllUsers() {
		logger.info("Fetching all users");
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		logger.info("Fetching user with ID: {}", id);
		return userRepository.findById(id);
	}
	
	@Override
	public User createUser(User user) {
		if (userRepository.findUserByEmail(user.getEmail()) != null) {
			throw new UserAlreadyExists("User with this email already exists!");
		} else if (userRepository.findUserByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExists("Username already exists!,Try Diiferent Username");
		}
		logger.info("Creating user with username: {}", user.getUsername());
//		user.setPassword(encoder.encode(user.getPassword()));
		User savedUser = userRepository.save(user);
//		emailserviceimpl.sendMailWithAttachment(savedUser); --> email service
		return savedUser;
	}

	@Override
	public User updateUser(Long id, User userDetails) {
		logger.info("Updating user with ID: {}", id);
		Optional<User> optionalUser = getUserById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setUsername(userDetails.getUsername());
			user.setEmail(userDetails.getEmail());
			user.setRole(userDetails.getRole());
			return userRepository.save(user);
		} else {
			logger.error("User with ID: {} not found", id);
			throw new UserNotFoundException("User with ID " + id + " not found.");
		}
	}

	@Override
	public void deleteUser(Long id) {
		logger.info("Deleting user with ID: {}", id);
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isEmpty()) {
			System.out.println("hello i deletion");
			logger.error("User with ID: {} not found", id);
			throw new UserNotFoundException("User with ID " + id + " not found.");

		} else {
			userRepository.delete(optionalUser.get());
		}
	}

	@Override
	public User getusername(String username) {
		logger.info("Fetching user by username: {}", username);
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User findByUserName(String username) {
		logger.info("Fetching user by username: {}", username);
		return userRepository.findUserByUsername(username);
	}
}