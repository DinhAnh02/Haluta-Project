package Haluta.example.demo.services.auth;

import Haluta.example.demo.dto.Auth.*;
import Haluta.example.demo.entity.Customer;
import Haluta.example.demo.enums.Role.CustomerRole;
import Haluta.example.demo.enums.Role.UserRole;
import Haluta.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final CustomerRepository customerRepository;

    public Customer findByEmail(LoginRequest loginRequest) {
        return customerRepository.findByEmail(loginRequest.getEmail());
    }

//    public Customer findByPhone(LoginRequest loginRequest) {
//        return customerRepository.findByPhone(loginRequest.getPhone());
//    }

    @Override
    public Customer createCustomer(SignUpRequest signupRequest) {
        Customer customer = new Customer();
        customer.setEmail(signupRequest.getEmail());
        customer.setCustomer_name(signupRequest.getFull_name());
        customer.setPhone(signupRequest.getPhone());
        customer.setFull_name(signupRequest.getFull_name());
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
        Customer customer = findByEmail(loginRequest);
        UserDto user = new UserDto();
        if(customer == null){return null;}
        else {
            if (loginRequest.getPassword().equals(customer.getPassword())) {
                  user.setId(customer.getCustomer_id());
            }
            else {
                return null;
            }
        }
        return user;
    }

}
