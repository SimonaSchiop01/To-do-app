package com.example.backend.Domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="users")

@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique=true, length=50)
    private String username;

    @Column(nullable = false, unique=true, length=100)
    private String email;

    @Column(nullable = false, unique=false, length=50)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
