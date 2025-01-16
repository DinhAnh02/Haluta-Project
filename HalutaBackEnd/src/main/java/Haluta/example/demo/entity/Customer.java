package Haluta.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    @Column(unique=true)
    private String customer_name;
    @Column(unique=true)
    private String email;
    private String full_name;
    private String password;
    private String again_password;
    private int phone;
    private String role;
    private String type_customer;

}
