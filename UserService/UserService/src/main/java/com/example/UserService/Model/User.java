package com.example.UserService.Model;
import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 50 characters")
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;
    
	@ElementCollection
	@CollectionTable(name="user_courses",joinColumns = @JoinColumn(name="user_id"))
	@Column(name="course_id")
	List<Long> courseId;
	
	@Email(message="Once Recheck the Email")
	@NotEmpty(message="Email must not be empty")
	private String email;
    
	
	@Size(min = 8,  message = "Password must be at least 8 characters long and contain at least one letter and one digit")
	private String password;

	public enum Role {
		STUDENT, INSTRUCTOR
	}
}
