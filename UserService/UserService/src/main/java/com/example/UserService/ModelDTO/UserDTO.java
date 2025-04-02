package com.example.UserService.ModelDTO;
import java.util.List;
import com.example.UserService.Model.User.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long userId;
	private String username;
	private String email;
	private Role role;
	private List<Long> courseId;
}
