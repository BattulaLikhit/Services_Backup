package com.example.CourseService.Model;
import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;
    
    private String title;
    private String description;
    private String contentURL;

    private Long instructorId; 

    @ElementCollection
    @CollectionTable(name = "course_enrollments", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "enrollment_id")
    private List<Long> enrollmentIds;

    @ElementCollection
    @CollectionTable(name = "course_videos", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "video_id")
    private List<Long> videoIds;

    @ElementCollection
    @CollectionTable(name = "course_assessments", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "assessment_id")
    private List<Long> assessmentIds;

}