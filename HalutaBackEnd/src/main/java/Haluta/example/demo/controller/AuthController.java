package Haluta.example.demo.controller;


import Haluta.example.demo.dto.Auth.*;
import Haluta.example.demo.entity.Customer;
import Haluta.example.demo.response.ResponseMessage;
import Haluta.example.demo.services.auth.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/{api_prefix}/public")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/auth/signup")
    public ResponseEntity<?> signupCustomer(@Valid @RequestBody SignUpRequest signUpRequest){
        Customer createdCustomer = authService.createCustomer(signUpRequest);
        if(createdCustomer == null){
            return new ResponseEntity<>("Customer not create", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new ResponseMessage("Created Success"));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginCustomer(@Valid @RequestBody LoginRequest loginRequest){
        UserDto loginCustomerDto = authService.loginCustomer(loginRequest);
        if(loginCustomerDto == null){
            return new ResponseEntity<>("Wrong email or password, please check again !", HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(new ResponseMessage("Login Success"));
    }

















}

