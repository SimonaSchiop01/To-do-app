package com.example.backend.Dtos.Authentification;

import lombok.Getter;
import lombok.Setter;


public class RequestNewPairsOfTokens {

    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
