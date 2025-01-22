package Haluta.example.demo.dto.Auth;


import Haluta.example.demo.enums.Role.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.*;



@Data
public class UserDto {
//    @JsonIgnore
//    @Digits(integer = 10, fraction = 0)
//    @NotNull(message = "Phone is required")
//    private Integer phone;
    @JsonIgnore
    private Long id;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}
