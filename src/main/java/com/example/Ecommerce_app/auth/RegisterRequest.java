package com.example.Ecommerce_app.auth;


import com.example.Ecommerce_app.entites.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private String address;
    private String phone;
    private String password;
}
