package com.example.backend.Controllers;

import com.example.backend.Domains.User;
import com.example.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("create")
    public User createUser(@RequestBody User user){
        this.userRepository.save(user);
        return user;
    }

    @GetMapping("get_all")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

}
