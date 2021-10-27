package com.revature.p2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.p2.beans.Character;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Integer> {


}
