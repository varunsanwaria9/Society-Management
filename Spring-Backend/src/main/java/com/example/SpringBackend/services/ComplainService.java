package com.example.SpringBackend.services;

import java.util.List;
import java.util.Optional;

import com.example.SpringBackend.database.entities.Complains;
import com.example.SpringBackend.database.entities.Residents;
import com.example.SpringBackend.database.enums.ComplainStage;
import com.example.SpringBackend.database.repos.ComplainRepo;

import com.example.SpringBackend.database.repos.ResidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainService {
    
    @Autowired
    private ComplainRepo complainRepo;
    @Autowired
    private ResidentRepo residentRepo;


    public Complains addComplains(Complains complains) {
        return complainRepo.save(complains);
    }

    public Complains getComplainByID(String id){
        Optional<Complains> complain = complainRepo.findById(id);
        return complain.orElse(null);
    }

    public List<Complains> getResidentComplainRaised(String id){
        Optional<Residents> resident = residentRepo.findById(id);
        if (resident.isEmpty()){
            return List.of();
        }
        return complainRepo.getResidentComplainRaised(resident.get().getResidence_ref().getResidence_id());
    }
    
    public List<Complains> getAllRaisedComplains(){
    	return complainRepo.getAllRaisedComplains();
    }
}
