package com.revature.p2.services;

import com.revature.p2.beans.User;
import com.revature.p2.exception.UsernameAlreadyExistsException;
import com.revature.p2.repositories.UserRepo;
import com.revature.p2.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User registerUser(User newUser){
        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique(exception)
            newUser.setUsername(newUser.getUsername());
            newUser.setFirstName(newUser.getFirstName());
            newUser.setLastName(newUser.getLastName());
            //Make sure that password and confirmPassword match
            //we don't persist and show the confirmPassword
            newUser.setConfirmPassword("");

            return userRepo.save(newUser);

        }catch (Exception e){
            throw  new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists.");
        }
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }


}
