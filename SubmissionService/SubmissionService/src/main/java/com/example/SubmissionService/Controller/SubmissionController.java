package com.example.SubmissionService.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SubmissionService.Model.Submission;
import com.example.SubmissionService.ModelDTO.SubmissionDTO;
import com.example.SubmissionService.Services.SubmissionService;

import java.util.List;

@RestController
@RequestMapping("api/submission")
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

	@PostMapping("")
	public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
		Submission createdSubmission = submissionService.createSubmission(submission);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdSubmission);
	}

	@GetMapping("")
	public ResponseEntity<List<SubmissionDTO>> getAllSubmissions() {
		List<SubmissionDTO> submissions = submissionService.getAllSubmissions();
		return ResponseEntity.ok(submissions);
	}

}