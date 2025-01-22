package Haluta.example.demo.dto.Auth;


import Haluta.example.demo.enums.Role.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.*;



@Data
public class UserDto {
    @JsonIgnore
    private Long id;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @JsonIgnore
    private UserRole userRole;
}
