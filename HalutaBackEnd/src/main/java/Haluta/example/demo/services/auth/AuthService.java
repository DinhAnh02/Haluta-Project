package Haluta.example.demo.services.auth;

import Haluta.example.demo.dto.Auth.SignUpRequest;
import Haluta.example.demo.dto.Auth.UserDto;


public interface AuthService  {
    UserDto createCustomer(SignUpRequest signUpRequest);
}
