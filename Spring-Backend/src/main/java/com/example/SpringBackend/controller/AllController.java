package com.example.SpringBackend.controller;

import java.util.List;
import java.util.Optional;

import com.example.SpringBackend.database.entities.Auth;
import com.example.SpringBackend.database.entities.Portfolio;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.models.LoginModel;
import com.example.SpringBackend.database.models.RegisterModel;
import com.example.SpringBackend.database.repos.AuthRepo;
import com.example.SpringBackend.database.repos.PortfolioRepo;
import com.example.SpringBackend.database.repos.ResidentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AllController {

    @Autowired
    private AuthRepo authRepo;
    @Autowired
    private ResidentRepo residentRepo;
    @Autowired
    private PortfolioRepo portfolioRepo;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginModel loginModel) {
        Optional<Auth> auth = authRepo.findByEmail(loginModel.getEmail());
        if(auth.isEmpty()){
            return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
        }
        if(!auth.get().getPassword().equals(loginModel.getPassword())){
            return new ResponseEntity<>("Invalid password", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterModel> register(@RequestBody RegisterModel registerModel) {
        Optional<Auth> auth = authRepo.findByEmail(registerModel.getEmail());
        if(auth.isPresent()){
            return new ResponseEntity<>(registerModel, HttpStatus.BAD_REQUEST);
        }
        Auth a1 = new Auth(registerModel.getEmail(), registerModel.getPassword(),"RESIDENT");
        Portfolio p1 = portfolioRepo.save(new Portfolio("NORMAL", 0));
        residentRepo.save(new Residents(registerModel.getName(), registerModel.getPhone_no(), 0, p1.getPortfolio_id(), List.of(), a1));
        return new ResponseEntity<>(registerModel, HttpStatus.OK);
    }
}
