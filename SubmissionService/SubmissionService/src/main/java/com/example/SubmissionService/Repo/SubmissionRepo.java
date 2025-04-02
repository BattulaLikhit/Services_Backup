package com.example.SubmissionService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SubmissionService.Model.Submission;


public interface SubmissionRepo extends JpaRepository<Submission, Long> {

}
