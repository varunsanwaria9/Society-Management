package com.example.societybackend.services;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthRepo authRepo;

    public List<Users> allUsers(){
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Auth> auth = authRepo.findByEmail(email);
        if(auth.isEmpty()) throw new UsernameNotFoundException("User not Found!!");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        auth.get().getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getRole().toString()));
        });
        return new User(auth.get().getEmail(),auth.get().getPassword(),authorities);
    }
}
