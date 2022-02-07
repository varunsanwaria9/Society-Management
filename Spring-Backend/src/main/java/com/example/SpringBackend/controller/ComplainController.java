package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Complains;
import com.example.SpringBackend.services.ComplainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/complain")
@CrossOrigin
public class ComplainController {
    
    @Autowired
    private ComplainService complainService;

    @PostMapping(path = "/add")
    public ResponseEntity<Complains> addComplains(@RequestBody Complains complains) {
        return new ResponseEntity<>(complainService.addComplains(complains),HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Complains> getComplainByID(@PathVariable Long id){
        Complains complain = complainService.getComplainByID(id);
        if(complain == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(complain,HttpStatus.OK);
    }

}
