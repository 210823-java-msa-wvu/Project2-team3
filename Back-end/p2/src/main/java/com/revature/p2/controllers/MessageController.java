package com.revature.p2.controllers;


import com.revature.p2.beans.Message;
import com.revature.p2.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    // instead of having a log object here and then writing log.trace() everywhere we want logging to happen
    // we are going to create an Aspect with Advice to take care of it - see com.revature.aspects.LoggingAspect

    // We haven't written any code or implementation for this (it's an interface)
    // But all of the methods that we are using in this class come from the JpaRepository<T, ID>
    private MessageRepo mRepo;

    @Autowired
    public MessageController(MessageRepo mRepo) {
        this.mRepo = mRepo;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return mRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Message getById(@PathVariable("id") int id) {
        return mRepo.getById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Message addMessage(@RequestBody Message message) {
        return mRepo.save(message);
    }

    @PutMapping(path="/{id}")
    public void updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
        if (id == message.getId()) {
            mRepo.save(message);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        mRepo.delete(mRepo.getById(id));
    }
}
