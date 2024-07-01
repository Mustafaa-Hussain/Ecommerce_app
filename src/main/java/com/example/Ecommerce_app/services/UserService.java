package com.example.Ecommerce_app.services;

import com.example.Ecommerce_app.controllers.user.UserResponse;
import com.example.Ecommerce_app.entites.user.User;
import com.example.Ecommerce_app.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<UserResponse> getUserData(String username) {
        User user = repository.findByEmail(username).orElseThrow();
        UserResponse helloResponse = new UserResponse();
        helloResponse.setEmail(user.getEmail());
        helloResponse.setRole(user.getRole());

        return ResponseEntity.ok(helloResponse);
    }
}
