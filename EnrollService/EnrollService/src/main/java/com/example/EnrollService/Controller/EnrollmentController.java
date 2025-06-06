package com.example.EnrollService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.EnrollService.Model.Enrollment;
import com.example.EnrollService.ModelDTO.EnrollmentDTO;
import com.example.EnrollService.Service.EnrollmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;
//
//	@PreAuthorize("hasRole('INSTRUCTOR')")
	@GetMapping
	public List<EnrollmentDTO> getAllEnrollments() {
		System.out.println("In the function");
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_STUDENT"))) {
//			System.out.println("Hello bro you are student");
//			throw new NotEnrolledException("Unauthroized access ,only Instructor can access!");
//
//		} else {
//			System.out.println("hello bro something isfishy");
			return enrollmentService.getAllEnrollments();
//		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
		Optional<EnrollmentDTO> enrollment = enrollmentService.getEnrollmentById(id);
		return new ResponseEntity<>(enrollment.get(), HttpStatus.ACCEPTED);
	}

//	@PreAuthorize("hasRole('STUDENT')")
	@PostMapping
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
		return enrollmentService.saveEnrollment(enrollment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
		enrollmentService.deleteEnrollment(id);
		return ResponseEntity.noContent().build();
	}
}