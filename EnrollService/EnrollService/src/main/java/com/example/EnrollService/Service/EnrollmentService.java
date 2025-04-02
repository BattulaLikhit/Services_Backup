package com.example.EnrollService.Service;




import java.util.List;
import java.util.Optional;

import com.example.EnrollService.Model.Enrollment;
import com.example.EnrollService.ModelDTO.EnrollmentDTO;

public interface EnrollmentService {
    List<EnrollmentDTO> getAllEnrollments();
    Optional<EnrollmentDTO> getEnrollmentById(Long id);
    Enrollment saveEnrollment(Enrollment enrollment);
    void deleteEnrollment(Long id);
}