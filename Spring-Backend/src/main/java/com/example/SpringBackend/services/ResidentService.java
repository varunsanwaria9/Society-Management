package com.example.SpringBackend.services;

import java.util.List;
import java.util.Optional;

import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.repos.ResidentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {
    
    @Autowired
    private ResidentRepo residentRepo;

    public Residents addResidents(Residents residents){
        return residentRepo.save(residents);
    }

    public Residents getResidentsById(String id){
        Optional<Residents> residents = residentRepo.findById(id);
        return residents.orElse(null);
    }

    public Residents updateResidents(Residents residents){
        return residentRepo.save(residents);
    }
    
    public Residents findByEmail(String email){
        return residentRepo.findByEmail(email);
    }

    public void deleteResidents(String id){
        residentRepo.deleteById(id);
    }
    
    public List<Residents> getAllResidentsByFlatNo(String flatNo){
        return residentRepo.findByFlatNo(flatNo);
    }

    public List<Residents> getAllResidentsByTower(int towerId){
        return residentRepo.findByTowerId(towerId);
    }
    
    public List<Residents> searchResidents(String search){
    	return residentRepo.serachResidents(search + "%");
    }
}
