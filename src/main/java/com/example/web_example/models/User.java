package com.example.web_example.models;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(name="role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    private Status status;

    public User() {

    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = Role.USER;
        this.status = Status.ACTIVE;
    }
}
