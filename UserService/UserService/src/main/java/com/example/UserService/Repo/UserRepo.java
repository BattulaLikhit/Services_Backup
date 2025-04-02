package com.example.UserService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.UserService.Model.User;


public interface UserRepo extends JpaRepository<User, Long>{
//	@Query(value="select * from user where username=:username",nativeQuery=true)
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	 
}
