package Haluta.example.demo.dto.Auth;


import Haluta.example.demo.enums.Role.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.*;



@Data
public class UserDto {

    @JsonIgnore
    private Long id;
    @NotBlank(message = "Email or phone number is required")
    private String username;
}
