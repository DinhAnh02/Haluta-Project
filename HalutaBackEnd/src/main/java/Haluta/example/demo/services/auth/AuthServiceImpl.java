package Haluta.example.demo.services.auth;

import Haluta.example.demo.dto.Auth.*;
import Haluta.example.demo.entity.Customer;
import Haluta.example.demo.enums.Role.CustomerRole;
import Haluta.example.demo.enums.Role.UserRole;
import Haluta.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDto createCustomer(SignUpRequest signupRequest) {
        Customer customer = new Customer();
        customer.setEmail(signupRequest.getEmail());
        customer.setPassword(signupRequest.getPassword());
        customer.setCustomer_name(signupRequest.getFull_name());
        customer.setPhone(signupRequest.getPhone());
        customer.setPassword(signupRequest.getPassword());
        customer.setFull_name(signupRequest.getFull_name());
        customer.setRole(String.valueOf(UserRole.CUSTOMERS));
        customer.setType_customer(String.valueOf(CustomerRole.SystemCustomer));
        UserDto userDto = new UserDto();
        Customer create = customerRepository.save(customer);
        userDto.setId(create.getId());
        return userDto;
    }

//     public Customer findByEmail(LoginRequest loginRequest) {
//         return userRepository.findByEmail(loginRequest.getEmail());
//     }
//
//     @Override
//     public UserDto loginCustomer(LoginRequest loginRequest) {
//         User user = findByEmail(loginRequest);
//         if (loginRequest.getPassword().equals(user.getPassword())) {
//             UserDto userDto = new UserDto();
//             userDto.setId(user.getId());
//             userDto.setEmail(user.getEmail());
//             return userDto;
//         }
//         return null;
//
//     }

}
