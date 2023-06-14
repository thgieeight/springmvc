package com.inventory.invmgtsys.config;

import com.inventory.invmgtsys.model.User;
import com.inventory.invmgtsys.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findInventoryUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Username not found");
        return new UserPrincipal(user);
    }
}