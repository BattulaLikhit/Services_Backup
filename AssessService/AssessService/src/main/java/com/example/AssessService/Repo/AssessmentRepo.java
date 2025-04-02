package com.example.AssessService.Repo
;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AssessService.Model.Assessment;


public interface AssessmentRepo extends JpaRepository<Assessment, Long> {

}
