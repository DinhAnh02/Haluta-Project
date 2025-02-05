package Haluta.example.demo.services.auth;

import Haluta.example.demo.dto.Auth.*;
import Haluta.example.demo.entity.Customer;
import Haluta.example.demo.enums.Role.CustomerRole;
import Haluta.example.demo.enums.Role.UserRole;
import Haluta.example.demo.exception.ConflictException;
import Haluta.example.demo.exception.InvalidException;
import Haluta.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(SignUpRequest signupRequest) {
        Customer customer = new Customer();
        for(Customer customers : customerRepository.findAll()) {
            if(Objects.equals(customers.getEmail(), signupRequest.getEmail())){
                throw new ConflictException("Email name already exists");
            }
            else if(Objects.equals(customers.getPhone(), signupRequest.getPhone())){
                throw new ConflictException("Phone already exists");
            }
            else if(Objects.equals(customers.getCustomer_name(), signupRequest.getCustomer_name())){
                throw new ConflictException("Customer name already exists");
            }
            else {
                customer.setPhone(signupRequest.getPhone());
                customer.setEmail(signupRequest.getEmail());
                customer.setCustomer_name(signupRequest.getCustomer_name());
                customer.setFull_name(signupRequest.getFull_name());
            }
        }
        if(Objects.equals(signupRequest.getAgain_password(), signupRequest.getPassword())){
            customer.setPassword(signupRequest.getPassword());
            customer.setAgain_password(signupRequest.getAgain_password());
            customer.setRole(String.valueOf(UserRole.CUSTOMERS));
            customer.setType_customer(String.valueOf(CustomerRole.SystemCustomer));
            if(customerRepository.findAll().isEmpty()){customer.setCustomer_id(1L);}
            else {customer.setCustomer_id((long) customerRepository.findAll().size() + 1);}
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public UserDto loginCustomer(LoginRequest loginRequest) {
        UserDto user = new UserDto();
        if (loginRequest.getUsername().matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            if(customerRepository.findByEmail(loginRequest.getUsername()) == null){
               return null;
            }
            if(loginRequest.getUsername().equals(customerRepository.findByEmail(loginRequest.getUsername()).getEmail())){
               if(loginRequest.getPassword().equals(customerRepository.findByEmail(loginRequest.getUsername()).getPassword())){
                   user.setId(customerRepository.findByEmail(loginRequest.getUsername()).getCustomer_id());
               }
               else {
                   return null;
               }
            }
        } else if (loginRequest.getUsername().matches("^\\d{9,}$")) {
            if(customerRepository.findByPhone(Integer.valueOf(loginRequest.getUsername())) == null){
                return null;
            }
            if(loginRequest.getUsername().equals(customerRepository.findByPhone(Integer.valueOf(loginRequest.getUsername())).getPhone().toString())){
                if(loginRequest.getPassword().equals(customerRepository.findByPhone(Integer.valueOf(loginRequest.getUsername())).getPassword())){
                    user.setId(customerRepository.findByPhone(Integer.valueOf(loginRequest.getUsername())).getCustomer_id());
                }
                else {
                    return null;
                }
            }
        } else {
            throw new InvalidException("Email or phone not invalid");
        }
        return user;
    }
}
