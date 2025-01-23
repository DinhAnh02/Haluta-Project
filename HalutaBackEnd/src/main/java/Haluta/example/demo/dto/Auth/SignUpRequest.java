package Haluta.example.demo.dto.Auth;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class SignUpRequest {
    @NotBlank(message = "Full name is required")
    @Pattern(regexp = "^[A-Za-zÀ-ỹ\\s]{1,255}$", message = "Full name must contain upppercase, lowercase letters and numbers, special symbol and whitespace")
    @Size(max = 255, message = "Full name must be 255 characters long")
    private String full_name;
    @NotBlank(message = "Username is required")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must contain upppercase, lowercase letters and numbers, special symbol")
    @Size(min = 8, max = 8, message = "Username must be 8 characters long")
    private String customer_name;
    @Size(min = 8, message = "Password must be 8-9 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain upppercase, lowercase letters and numbers, special symbol")
    @NotBlank(message = "Password is required")
    private String password;
    @Size(min = 8,  message = "Password must be 8-9 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain upppercase, lowercase letters and numbers, special symbol")
    @NotBlank(message = "AgainPassword is required")
    private String again_password;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
    @Digits(integer = 10, fraction = 0)
    @NotNull(message = "Phone is required")
    private Integer phone;


}