package com.example.CourseService.ModelDTO;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long courseID;
    private String title;
    private String description;
    private String contentURL;
    private Long instructorId; 
    private List<Long> enrollmentIds; 
    private List<Long> videoIds; 
    private List<Long> assessmentIds; 
}
