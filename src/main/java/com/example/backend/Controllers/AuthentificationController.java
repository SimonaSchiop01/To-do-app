package com.example.backend.Controllers;

import com.example.backend.Domains.User;
import com.example.backend.Dtos.Authentification.BearerTokensDtoResponse;
import com.example.backend.Dtos.Authentification.RequestTokensDto;
import com.example.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentification-controller")
public class AuthentificationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public BearerTokensDtoResponse loginUser(RequestTokensDto requestTokensDto){
        User user = this.userRepository.findByEmailAndPassword(requestTokensDto.getEmail(), requestTokensDto.getPassword()).orElse(null);
        if(user==null){
            BearerTokensDtoResponse response = new BearerTokensDtoResponse("","","Wrong credentials", 401);
            return response;
        }else{
            BearerTokensDtoResponse response = new BearerTokensDtoResponse("aa","bb","Login Successfully", 200);
            return response;
        }
    }
}
