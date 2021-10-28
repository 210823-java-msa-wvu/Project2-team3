package com.revature.p2.repositories;

import com.revature.p2.beans.DNDUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<DNDUser, Integer> {
    DNDUser findByUsername(String username);

}
