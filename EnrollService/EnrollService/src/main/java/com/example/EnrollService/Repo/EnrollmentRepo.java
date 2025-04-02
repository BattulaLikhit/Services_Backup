package com.example.EnrollService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EnrollService.Model.Enrollment;



public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

}
