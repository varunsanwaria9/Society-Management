package com.example.SpringBackend.controller;

import java.util.List;
import java.util.Optional;

import com.example.SpringBackend.database.entities.*;
import com.example.SpringBackend.database.enums.AuthRole;
import com.example.SpringBackend.database.models.*;
import com.example.SpringBackend.database.repos.*;
import com.example.SpringBackend.services.ManagerService;
import com.example.SpringBackend.services.ResidentService;
import com.example.SpringBackend.services.SupervisorService;

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
    @Autowired
    private ManagerService managerService;
    @Autowired
    private SupervisorService supervisorService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginModel loginModel) throws Exception {
        Optional<Auth> auth = authRepo.findByEmail(loginModel.getEmail());
        if(auth.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!auth.get().getPassword().equals(loginModel.getPassword())){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Auth a1 = auth.get();
        if(a1.getRoles() == AuthRole.RESIDENT)
        	return new ResponseEntity<>( residentService.findByEmail(loginModel.getEmail()).getResident_id() + " " + auth.get().getRoles().toString(), HttpStatus.OK);
        else if(a1.getRoles() == AuthRole.MANAGER)
        	return new ResponseEntity<>( managerService.getManagerByEmail(loginModel.getEmail()).getManager_id() + " " + auth.get().getRoles().toString(),HttpStatus.OK);
        else if(a1.getRoles() == AuthRole.SUPERVISOR)
        	return new ResponseEntity<>( supervisorService.getSupervisorByEmail(loginModel.getEmail()).getSupervisor_id() + " " + auth.get().getRoles().toString(),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<Auth> updatePassword(@RequestBody UpdatePasswordModel updatePasswordModel){
        Optional<Auth> auth1 = authRepo.findByEmail(updatePasswordModel.getEmail());
        if(auth1.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else if(auth1.get().getPassword().equals(updatePasswordModel.getOldPwd())){
            Auth a1 = auth1.get();
            a1.setPassword(updatePasswordModel.getNewPwd());
            return new ResponseEntity<>(authRepo.save(a1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/register")
    public ResponseEntity<Residents> register(@RequestBody RegisterModel registerModel){
       Optional<Auth> auth = authRepo.findByEmail(registerModel.getEmail());
       if (auth.isPresent()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       Auth auth1 = new Auth(registerModel.getEmail(), registerModel.getPassword(), AuthRole.RESIDENT);
       Residents residents = new Residents(registerModel.getName(), registerModel.getPhone_no(), new Portfolio("NORMAL",1),auth1);
       return new ResponseEntity<>(residentService.addResidents(residents),HttpStatus.CREATED);
    }

    
}
