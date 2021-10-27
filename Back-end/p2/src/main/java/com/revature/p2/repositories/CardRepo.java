package com.revature.p2.repositories;


import com.revature.p2.beans.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card,Integer> {

}
