package com.example.Ecommerce_app.repositores;

import com.example.Ecommerce_app.entites.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
