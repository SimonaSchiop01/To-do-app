package com.example.backend.Controllers;

import com.example.backend.BussinesLogic.BearerTokensGenerator;
import com.example.backend.Domains.User;
import com.example.backend.Domains.UserLoginHistory;
import com.example.backend.Dtos.Authentification.BearerTokensDtoResponse;
import com.example.backend.Dtos.Authentification.RequestNewPairsOfTokens;
import com.example.backend.Dtos.Authentification.RequestTokensDto;
import com.example.backend.Repositories.UserLoginHistoryRepository;
import com.example.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/authentification-controller")
public class AuthentificationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginHistoryRepository userLoginHistoryRepository;

    @PostMapping("GeneratePairsOfTokens")
    public BearerTokensDtoResponse loginUser(RequestTokensDto requestTokensDto) {
        User user = this.userRepository.findByEmailAndPassword(requestTokensDto.getEmail(), requestTokensDto.getPassword()).orElse(null);
        if(user == null) {
            return new BearerTokensDtoResponse("","","Wrong credentials",401);
        }
        BearerTokensGenerator generator = new BearerTokensGenerator();
        String accessToken = generator.generateAccessToken(user.getEmail());
        String refreshToken = generator.generateRefreshToken();
        BearerTokensDtoResponse response = new BearerTokensDtoResponse(accessToken,refreshToken,"Login successfully",200);

        UserLoginHistory userLoginHistory = this.userLoginHistoryRepository.findByUser(user).orElse(null);
        if(userLoginHistory == null) {
            userLoginHistory = new UserLoginHistory();
            userLoginHistory.setUser(user);
        }
        userLoginHistory.setCurrentRefreshToken(refreshToken);
        userLoginHistory.setCurrentAccessToken(accessToken);
        userLoginHistoryRepository.save(userLoginHistory);
        return response;
    }

    @PostMapping("GenerateNewPairsOfTokens")
    public BearerTokensDtoResponse refreshToken(RequestNewPairsOfTokens  requestNewPairsOfTokens) {
        UserLoginHistory userLoginHistory = this.userLoginHistoryRepository.findByCurrentRefreshToken(requestNewPairsOfTokens.getRefreshToken()).orElse(null);
       if(userLoginHistory == null) {
           return new BearerTokensDtoResponse("","","Your account was corrupted , we will freeze it temporary",401);
       }
       BearerTokensGenerator generator = new BearerTokensGenerator();
       String newAccessToken = generator.generateAccessToken(userLoginHistory.getUser().getEmail());
       String newRefreshToken = generator.generateRefreshToken();

        userLoginHistory.setCurrentRefreshToken(newRefreshToken);
        userLoginHistory.setCurrentAccessToken(newAccessToken);
       userLoginHistoryRepository.save(userLoginHistory);
        BearerTokensDtoResponse response = new BearerTokensDtoResponse(newAccessToken,newRefreshToken,"Refresh successfully",200);
        return response;
    }
}
