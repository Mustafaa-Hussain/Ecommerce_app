package com.example.Ecommerce_app.services;

import com.example.Ecommerce_app.api.form_model.RegistrationBody;
import com.example.Ecommerce_app.data_model.User;
import com.example.Ecommerce_app.data_model.repositories.UserRepository;
import com.example.Ecommerce_app.exiption.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {
        if(userRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
        || userRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistException();
        }

        User user = new User();
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setFirstname(registrationBody.getFirstname());
        user.setLastname(registrationBody.getLastname());
        //Todo encrypt password before store it
        user.setPassword(registrationBody.getPassword());
        return userRepo.save(user);
    }
}
