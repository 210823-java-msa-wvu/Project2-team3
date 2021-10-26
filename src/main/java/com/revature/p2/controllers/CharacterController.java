package com.revature.p2.controllers;


import com.revature.p2.repositories.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.revature.p2.beans.Character;

import java.util.List;


@RestController
@RequestMapping("/characters")
public class CharacterController {


    // instead of having a log object here and then writing log.trace() everywhere we want logging to happen
    // we are going to create an Aspect with Advice to take care of it - see com.revature.aspects.LoggingAspect

    // We haven't written any code or implementation for this (it's an interface)
    // But all of the methods that we are using in this class come from the JpaRepository<T, ID>
    private CharacterRepo charRepo;

    @Autowired
    public CharacterController(CharacterRepo charRepo) {
        this.charRepo = charRepo;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return charRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Character getById(@PathVariable("id") int id) {
        return charRepo.getById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Character addCharacter(@RequestBody Character character) {
        return charRepo.save(character);
    }

    @PutMapping(path="/{id}")
    public void updateCharacter(@PathVariable("id") int id, @RequestBody Character character) {
        if (id == character.getId()) {
            charRepo.save(character);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        charRepo.delete(charRepo.getById(id));
    }
}
