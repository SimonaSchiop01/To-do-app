package com.example.backend.Controllers;

import com.example.backend.Domains.User;
import com.example.backend.Dtos.Authentification.UserCreateRequestDto;
import com.example.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("create")
    public User createUser(@RequestBody UserCreateRequestDto userCreateRequestDto){
        User user = new User();
        user.setEmail(userCreateRequestDto.getEmail());
        user.setPassword(userCreateRequestDto.getPassword());
        user.setUsername(userCreateRequestDto.getUsername());
        this.userRepository.save(user);
        return user;
    }

    @GetMapping("get_all")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    @GetMapping("{email}")
    public Optional<User> findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

}
