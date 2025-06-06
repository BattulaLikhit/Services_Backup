package com.example.CourseService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CourseService.Exceptions.CourseIdNotFoundException;
import com.example.CourseService.Exceptions.ResourceIdNotFoundException;
import com.example.CourseService.Model.Course;
import com.example.CourseService.ModelDTO.CourseDTO;
import com.example.CourseService.Repo.CourseRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImp implements CourseService {


    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImp.class);

    @Autowired
    private CourseRepo courseRepository;
    @Autowired
    private UserRepo userRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        logger.info("Fetching all courses");
        return courseRepository.findAll().stream().map(course->convertToDTO(course)).collect(Collectors.toList());
    }
    
    @Override
    public Optional<CourseDTO> getCourseById(Long id) {
        logger.info("Fetching course with ID: {}", id);
        if(courseRepository.findById(id).isEmpty()) {
        	throw new CourseIdNotFoundException("Course Id Not Found");
        }
        return courseRepository.findById(id).map(course->convertToDTO(course));
    }

    @Override
    public Course saveCourse(Course course) {

        logger.info("Saving course with instructor ID: {}", course.getInstructor().getUserID());
        if (userRepository.findById(course.getInstructor().getUserID()).isEmpty()) {
            logger.error("Instructor with ID: {} not found", course.getInstructor().getUserID());

            throw new ResourceIdNotFoundException("Sorry the user/instructor not found!");
        }
        return courseRepository.save(course);
    }
    

    @Override
    public void deleteCourse(Long id) {
        logger.info("Deleting course with ID: {}", id);
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) throws ResourceIdNotFoundException {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isEmpty()) {
            throw new ResourceIdNotFoundException("Course not found with id: " + id);
        }
        Course updatedCourse = existingCourse.get();
        updatedCourse.setTitle(course.getTitle());
        updatedCourse.setDescription(course.getDescription());
        updatedCourse.setInstructorId(course.getInstructorId());
        return courseRepository.save(updatedCourse);
    }
    
    private CourseDTO convertToDTO(Course course) {
//    	 List<Long>videoIDS=course.getVideoIds().stream().map(video->video.).collect(Collectors.toList());
    	  return new CourseDTO(
    			  course.getCourseID(),
    			  course.getTitle(),
    			  course.getDescription(),
    			  course.getContentURL(),
    			  course.getInstructorId(),
    			  course.getEnrollmentIds(),
    			  course.getVideoIds(),
    			  course.getAssessmentIds()
          );
    }
}




