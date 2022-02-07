package com.example.SpringBackend.controller;

import java.util.List;

import com.example.SpringBackend.database.entities.Residences;
import com.example.SpringBackend.services.ResidenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    
    @Autowired
    private ResidenceService residenceService;


    @GetMapping("/residences/id/{id}")
    public ResponseEntity<Residences> getResidenceById(@PathVariable long id){
        Residences residences = residenceService.getResidenceById(id);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }

    @GetMapping("/residences/tower/{towerId}")
    public ResponseEntity<List<Residences>> getResidencesByTower(@PathVariable int towerId){
        List<Residences> residences = residenceService.getResidencesByTower(towerId);
        if(residences == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(residences, HttpStatus.OK);
    }
    
}
