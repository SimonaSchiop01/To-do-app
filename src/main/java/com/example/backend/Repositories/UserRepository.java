package com.example.backend.Repositories;

import com.example.backend.Domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);

}
