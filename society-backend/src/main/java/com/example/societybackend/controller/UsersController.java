package com.example.societybackend.controller;

import com.example.societybackend.databases.entities.Users;
import com.example.societybackend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(path = "/allUsers")
    public List<Users> allUsers(){
        return usersService.allUsers();
    }
}
