package Haluta.example.demo.dto.Auth;


import Haluta.example.demo.enums.Role.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;


@Valid
@Data
@NoArgsConstructor
@Getter
@Setter

public class UserDto {
    private Long id;
    @NotEmpty(message = "ko dc de trong")
    private String username;
    @Email(message = "Sai kieu email")
    private String email;
    private UserRole userRole;
}
