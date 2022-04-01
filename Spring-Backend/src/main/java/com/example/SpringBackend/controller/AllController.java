package com.example.SpringBackend.controller;

import java.util.List;
import java.util.Optional;

import com.example.SpringBackend.database.entities.*;
import com.example.SpringBackend.database.enums.AuthRole;
import com.example.SpringBackend.database.models.*;
import com.example.SpringBackend.database.repos.*;

import com.example.SpringBackend.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AllController {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private ResidentService residentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginModel loginModel) {
        Optional<Auth> auth = authRepo.findByEmail(loginModel.getEmail());
        if(auth.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!auth.get().getPassword().equals(loginModel.getPassword())){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(loginModel.getEmail() + " " + auth.get().getRoles().toString(), HttpStatus.OK);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<Auth> updatePassword(@RequestBody Auth auth){
        Optional<Auth> auth1 = authRepo.findByEmail(auth.getEmail());
        if (auth1.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else if (auth.getPassword().equals(auth1.get().getPassword())){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(authRepo.save(auth),HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<Residents> register(@RequestBody RegisterModel registerModel){
       Optional<Auth> auth = authRepo.findByEmail(registerModel.getEmail());
       if (auth.isPresent()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       Auth auth1 = new Auth(registerModel.getEmail(), registerModel.getPassword(), AuthRole.RESIDENT);
       Residents residents = new Residents(registerModel.getName(), registerModel.getPhone_no(), new Portfolio("NORMAL",1), List.of(),auth1);
       return new ResponseEntity<>(residentService.addResidents(residents),HttpStatus.CREATED);
    }

    
}
