package com.example.Ecommerce_app.api.form_model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegistrationBody {
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password length at least 8 characters and contains at least contains one digit.")
    private String password;
    @NotNull
    private String firstname;
    @NotNull
    @NotBlank
    private String lastname;
}