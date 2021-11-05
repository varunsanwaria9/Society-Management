package com.example.societybackend.controller;

import com.example.societybackend.databases.entities.*;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private AuthRepo authRepo;

    @GetMapping(path = "/allUsers")
    public List<Person> allUsers(){
        return personService.allUsers();
    }

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Optional<Person>> personById(@PathVariable String id){
		return new ResponseEntity<>(personService.getById(id),HttpStatus.OK);
	}

}


