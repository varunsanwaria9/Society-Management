package com.example.SpringBackend.services;

import java.util.List;
import java.util.Optional;
import com.example.SpringBackend.database.entities.Residences;
import com.example.SpringBackend.database.repos.ResidenceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidenceService {
    
    @Autowired
    private ResidenceRepo residenceRepo;
    
    public Residences addResidence(Residences residences){
        return residenceRepo.save(residences);
    }

    public Residences getResidenceById(String id){
        Optional<Residences> residence = residenceRepo.findById(id);
        return residence.orElse(null);
    }

    public Residences updateResidences(Residences residences){
        return residenceRepo.save(residences);
    }
    
    public boolean deleteResidence(String id){
        residenceRepo.deleteById(id);
        return true;
    }

    public Residences getResidenceByFlatNo(String flatNo){
        Optional<Residences> residences = residenceRepo.findByFlatNo(flatNo);
        return residences.orElse(null);
    }
    
    public List<Residences> getResidencesByTower(int towerId){
        return residenceRepo.findByTower(towerId);
    }

    public List<Residences> getResidencesByFloor(int floorId){
        return residenceRepo.findByFloor(floorId);
    }

    public List<Residences> getResidenceByTowerFloor(int towerId, int floorNo){
        return residenceRepo.findByTowerAndFloor(towerId, floorNo);
    }
    
}
