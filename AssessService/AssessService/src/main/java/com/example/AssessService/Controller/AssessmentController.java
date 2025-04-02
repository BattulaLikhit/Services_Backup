package com.example.AssessService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.AssessService.Exception.ResourceIdNotFoundException;
import com.example.AssessService.Model.Assessment;
import com.example.AssessService.ModelDTO.AssessmentDTO;
import com.example.AssessService.Service.AssessmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

	@Autowired
	private AssessmentService assessmentService;

//	@PreAuthorize("hasRole('STUDENT')") // --> only student roles can access this link
	@GetMapping
	public List<AssessmentDTO> getAllAssessments() {
		return assessmentService.getAllAssessments();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssessmentDTO> getAssessmentById(@PathVariable Long id) {
		Optional<AssessmentDTO> assessment = assessmentService.getAssessmentById(id);
		if (assessment.isPresent()) {
			return new ResponseEntity<>(assessment.get(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@PreAuthorize("hasRole('INSTRUCTOR')")
	@PostMapping
	public Assessment createAssessment(@RequestBody Assessment assessment) {
		return assessmentService.saveAssessment(assessment);
	}

//	@PreAuthorize("hasRole('INSTRUCTOR')")
	@PutMapping("/{id}")
	public ResponseEntity<Assessment> updateAssessment(@PathVariable Long id, @RequestBody Assessment assessment,@RequestParam int instructorid) {
		try {
			Assessment updatedAssessment = assessmentService.updateAssessment(id, assessment,instructorid);
			return new ResponseEntity<>(updatedAssessment, HttpStatus.OK);
		} catch (ResourceIdNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAssessment(@PathVariable Long id) {
		assessmentService.deleteAssessment(id);
		return ResponseEntity.noContent().build();
	}
}
