package com.example.AssessService.Service;


import java.util.List;
import java.util.Optional;

import com.example.AssessService.Model.Assessment;
import com.example.AssessService.ModelDTO.AssessmentDTO;

public interface AssessmentService {
    List<AssessmentDTO> getAllAssessments();
    Optional<AssessmentDTO> getAssessmentById(Long id);
    Assessment saveAssessment(Assessment assessment);
//    Assessment updateAssessment(Long id, Assessment assessment,int instructorid);
    void deleteAssessment(Long id);
}
