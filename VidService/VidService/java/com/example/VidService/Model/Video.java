package com.example.VidService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Long vidoeid;
	private String videourl;
	
	@JoinColumn(name="courseid")
	private Long courseId;

}
