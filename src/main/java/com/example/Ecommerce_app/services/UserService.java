package com.example.Ecommerce_app.services;

import com.example.Ecommerce_app.api.form_model.LoginBody;
import com.example.Ecommerce_app.api.form_model.RegistrationBody;
import com.example.Ecommerce_app.data_model.User;
import com.example.Ecommerce_app.data_model.repositories.UserRepository;
import com.example.Ecommerce_app.exiption.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    protected JWTService jwtService;

    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {
        if (userRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || userRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistException();
        }

        User user = new User();
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setFirstname(registrationBody.getFirstname());
        user.setLastname(registrationBody.getLastname());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return userRepo.save(user);
    }

    public String loginUser(LoginBody loginBody) {
        Optional<User> opUser = userRepo.findByUsernameIgnoreCase(loginBody.getUsername());
        if (opUser.isPresent()) {
            User user = opUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJwt(user);
            }
        }
        return null;
    }
}
