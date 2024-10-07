package com.example.Ecommerce_app.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.Ecommerce_app.data_model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    private static final String USERNAME_KEY = "USERNAME";
    private static final String EMAIL_KEY = "EMAIL";

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issure}")
    private String issure;
    @Value("${jwt.expireInSeconds}")
    private int expireInSeconds;
    private Algorithm algorithm;

    @PostConstruct
    public void postConstructor() {
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generateJwt(User user) {
        return JWT.create()
                .withClaim(USERNAME_KEY, user.getUsername())
                .withClaim(EMAIL_KEY, user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expireInSeconds)))
                .withIssuer(issure)
                .sign(algorithm);
    }

}
