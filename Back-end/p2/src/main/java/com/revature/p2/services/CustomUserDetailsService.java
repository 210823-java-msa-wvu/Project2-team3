package com.revature.p2.services;


import com.revature.p2.beans.User;
import com.revature.p2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) new UsernameNotFoundException("Username not found");
        return user;
    }
    @Transactional
    public User loadUserById(Integer id){
        User user = userRepo.getById(id);
        if (user==null) new UsernameNotFoundException("Username not found");
        return user;
    }
}
