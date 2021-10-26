package com.revature.p2.controllers;


import com.revature.p2.beans.User;
import com.revature.p2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // instead of having a log object here and then writing log.trace() everywhere we want logging to happen
    // we are going to create an Aspect with Advice to take care of it - see com.revature.aspects.LoggingAspect

    // We haven't written any code or implementation for this (it's an interface)
    // But all of the methods that we are using in this class come from the JpaRepository<T, ID>
    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public User getById(@PathVariable("id") int id) {
        return userRepo.getById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping(path="/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (id == user.getId()) {
            userRepo.save(user);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userRepo.delete(userRepo.getById(id));
    }

}
