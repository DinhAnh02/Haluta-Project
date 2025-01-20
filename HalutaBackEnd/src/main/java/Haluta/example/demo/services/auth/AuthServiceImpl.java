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
            else {for(int i = 0; i < customerRepository.findAll().size(); i++) { customer.setCustomer_id((long) customerRepository.findAll().size() + 1);}}
            return customerRepository.save(customer);
        }
        return null;
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
