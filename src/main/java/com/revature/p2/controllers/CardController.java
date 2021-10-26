package com.revature.p2.controllers;


import com.revature.p2.beans.Card;
import com.revature.p2.repositories.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {


    // instead of having a log object here and then writing log.trace() everywhere we want logging to happen
    // we are going to create an Aspect with Advice to take care of it - see com.revature.aspects.LoggingAspect

    // We haven't written any code or implementation for this (it's an interface)
    // But all of the methods that we are using in this class come from the JpaRepository<T, ID>
    private CardRepo cardRepo;

    @Autowired
    public CardController(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public Card getById(@PathVariable("id") int id) {
        return cardRepo.getById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Card addCard(@RequestBody Card card) {
        return cardRepo.save(card);
    }

    @PutMapping(path="/{id}")
    public void updateCard(@PathVariable("id") int id, @RequestBody Card card) {
        if (id == card.getId()) {
            cardRepo.save(card);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        cardRepo.delete(cardRepo.getById(id));
    }
}
