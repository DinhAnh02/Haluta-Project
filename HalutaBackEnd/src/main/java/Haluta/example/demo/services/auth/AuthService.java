package Haluta.example.demo.services.auth;

import Haluta.example.demo.dto.Auth.LoginRequest;
import Haluta.example.demo.dto.Auth.SignUpRequest;
import Haluta.example.demo.dto.Auth.UserDto;
import Haluta.example.demo.entity.Customer;


public interface AuthService  {
    Customer createCustomer(SignUpRequest signUpRequest);
    UserDto loginCustomer(LoginRequest loginRequest);
}
