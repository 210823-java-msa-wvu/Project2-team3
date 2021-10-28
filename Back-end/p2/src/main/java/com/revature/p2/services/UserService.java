package com.revature.p2.services;

import com.revature.p2.beans.DNDUser;
import com.revature.p2.exception.UsernameAlreadyExistsException;
import com.revature.p2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public DNDUser registerUser(DNDUser newDNDUser){
        try{
            newDNDUser.setPassword(bCryptPasswordEncoder.encode(newDNDUser.getPassword()));
            //Username has to be unique(exception)
            newDNDUser.setUsername(newDNDUser.getUsername());
            //Make sure that password and confirmPassword match
            //we don't persist and show the confirmPassword
            newDNDUser.setConfirmPassword("");

            return userRepo.save(newDNDUser);

        }catch (Exception e){
            throw  new UsernameAlreadyExistsException("Username '"+ newDNDUser.getUsername()+"' already exists.");
        }
    }

    public List<DNDUser> getAllUsers(){
        return userRepo.findAll();
    }


}
