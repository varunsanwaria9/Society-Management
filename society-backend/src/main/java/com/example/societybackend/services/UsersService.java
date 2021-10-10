package com.example.societybackend.services;

import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.databases.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepo;

    public List<Users> allUsers(){
        return userRepo.findAll();
    }
}
