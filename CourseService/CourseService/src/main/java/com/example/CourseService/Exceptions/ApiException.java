package com.example.CourseService.Exceptions;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
	private String messsage;
	private String path;
	private LocalDateTime time;

}
