package com.example.backend.Dtos.Authentification;

import lombok.Getter;
import lombok.Setter;


public class RequestNewPairsOfTokens {

    private String userEmail;

    private String refreshToken;

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
