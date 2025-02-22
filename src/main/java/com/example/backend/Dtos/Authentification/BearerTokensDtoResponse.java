package com.example.backend.Dtos.Authentification;

public class BearerTokensDtoResponse {
    private String accessToken;
    private String refreshToken;

    private String message;

    private int errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public BearerTokensDtoResponse(String accessToken, String refreshToken, String message, int errorCode) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.message = message;
        this.errorCode = errorCode;
    }
}
