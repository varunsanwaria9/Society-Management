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
    public ResponseEntity<String> getSupervisorById(@PathVariable long id){
        try{
            Supervisor supervisor = supervisorService.getSupervisorById(id);
            return new ResponseEntity<>(supervisor.toString(),HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profile/email/{email}")
    public ResponseEntity<Supervisor> getSupervisorByEmail(@PathVariable String email){
        try{
            Supervisor supervisor = supervisorService.getSupervisorByEmail(email);
            return new ResponseEntity<>(supervisor,HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/profile/update/supervisor")
    public ResponseEntity<Supervisor> updateSupervisorProfile(@RequestBody Supervisor supervisor){
        return new ResponseEntity<>(supervisorService.updateSupervisor(supervisor),HttpStatus.CREATED);
    }
}
