package com.example.SpringBackend.controller;

import com.example.SpringBackend.database.entities.Supervisor;
import com.example.SpringBackend.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @GetMapping("/profile/get/{id}")
    public ResponseEntity<Supervisor> getSupervisorById(@PathVariable String id){
        Supervisor supervisor = supervisorService.getSupervisorById(id);
        if(supervisor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(supervisor,HttpStatus.OK);
    }

    @GetMapping("/profile/email/{email}")
    public ResponseEntity<Supervisor> getSupervisorByEmail(@PathVariable String email){
        Supervisor supervisor = supervisorService.getSupervisorByEmail(email);
        if (supervisor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(supervisor,HttpStatus.OK);
    }

    @PutMapping("/profile/update/supervisor")
    public ResponseEntity<Supervisor> updateSupervisorProfile(@RequestBody Supervisor supervisor){
        return new ResponseEntity<>(supervisorService.updateSupervisor(supervisor),HttpStatus.CREATED);
    }
}
