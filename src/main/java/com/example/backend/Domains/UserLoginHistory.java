package com.example.backend.Domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_login_history")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String CurrentAccessToken;

    private String CurrentRefreshToken;
}
