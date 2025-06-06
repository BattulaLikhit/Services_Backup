package com.example.CourseService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.CourseService.Model.Course;
import com.example.CourseService.ModelDTO.CourseDTO;
import com.example.CourseService.Service.CourseService;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<CourseDTO> getAllCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
		Optional<CourseDTO> course = courseService.getCourseById(id);
		return new ResponseEntity<>(course.get(), HttpStatus.ACCEPTED);
	}

	// Only INSTRUCTOR role can access this
//    @PreAuthorize("hasRole('INSTRUCTOR')")
	@PostMapping("")
	public Course createCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return ResponseEntity.noContent().build();
	}
}
