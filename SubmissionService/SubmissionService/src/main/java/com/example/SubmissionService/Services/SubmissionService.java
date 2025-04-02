package com.example.SubmissionService.Services;


import java.util.List;
import java.util.Optional;

import com.example.SubmissionService.Model.Submission;
import com.example.SubmissionService.ModelDTO.SubmissionDTO;

public interface SubmissionService {
    Submission createSubmission(Submission submission);
    List<SubmissionDTO> getAllSubmissions();
    Optional<SubmissionDTO> getSubmissionById(Long id);
}