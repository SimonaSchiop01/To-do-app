package com.example.backend.BussinesLogic;


import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import static javax.crypto.Cipher.SECRET_KEY;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

public class BearerTokensGenerator {
    private String secretKey="abcoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
    private long accessTokenExpiration = 5*60*1000; // 5 minute
    private final SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    public String generateAccessToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

//e o cheie pe care o legam cu access tokenul
    public String generateRefreshToken(){
        byte[] randomBytes = new byte[32];
        new SecureRandom().nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }
}

//https://www.baeldung.com/spring-boot-api-key-secret
//https://www.qovery.com/blog/how-we-create-api-tokens-using-spring-boot/