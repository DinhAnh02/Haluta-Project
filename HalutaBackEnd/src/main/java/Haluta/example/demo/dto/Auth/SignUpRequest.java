package Haluta.example.demo.dto.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@NoArgsConstructor
@Setter
@Getter

public class SignUpRequest {
    @NotBlank(message = "Fullname is required")
    private String full_name;
    @NotBlank(message = "Username is required")
    private String customer_name;
    @Size(min = 8, max = 9, message = "Password must be 8-9 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain upppercase, lowercase letters and numbers, special symbol")
    @NotBlank(message = "Password is required")
    private String password;
    @Size(min = 8, max = 9, message = "Password must be 8-9 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain upppercase, lowercase letters and numbers, special symbol")
    @NotBlank(message = "AgainPassword is required")
    private String again_password;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
    @Size(min = 10, max = 10, message = "Phone must have 10 characters")
    @Pattern(regexp = "^(0|\\+84)(2[0-9]|3[2-9]|5[6-9]|7[0-9]|8[1-9]|9[0-9])[0-9]{7,8}$", message = "Must have only number")
    @NotBlank(message = "Phone is required")
    private int phone;


}