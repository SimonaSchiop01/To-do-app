package com.example.backend.Domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Column(nullable = false, unique=true, length=50)
    private String username;

    @Column(nullable = false, unique=true, length=100)
    private String email;

    @Column(nullable = false, unique=false, length=50)
    private String password;
}
