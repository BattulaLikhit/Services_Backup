package com.example.CourseService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseService.Model.Course;


public interface CourseRepo extends JpaRepository<Course, Long>{

}
