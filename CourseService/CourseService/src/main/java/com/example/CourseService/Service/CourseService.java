package com.example.CourseService.Service;


import java.util.List;
import java.util.Optional;

import com.example.CourseService.Exceptions.ResourceIdNotFoundException;
import com.example.CourseService.Model.Course;
import com.example.CourseService.ModelDTO.CourseDTO;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    Optional<CourseDTO> getCourseById(Long id);
    Course saveCourse(Course course) throws ResourceIdNotFoundException;
    Course updateCourse(Long id, Course course) throws ResourceIdNotFoundException;
    void deleteCourse(Long id);
}
