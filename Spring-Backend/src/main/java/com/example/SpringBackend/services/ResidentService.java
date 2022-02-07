package com.example.SpringBackend.services;

import java.util.List;

import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.repos.ResidentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {
    
    @Autowired
    private ResidentRepo residentRepo;

    public List<Residents> getAllResidents() {
        return residentRepo.findAll();
    }

}
