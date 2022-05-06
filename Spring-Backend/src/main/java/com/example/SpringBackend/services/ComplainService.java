package com.example.SpringBackend.services;

import java.util.Optional;

import com.example.SpringBackend.database.entities.Complains;
import com.example.SpringBackend.database.enums.ComplainStage;
import com.example.SpringBackend.database.repos.ComplainRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ComplainService {
    
    @Autowired
    private ComplainRepo complainRepo;

    public Complains addComplains(@RequestBody Complains complains) {
        return complainRepo.save(complains);
    }

    public Complains getComplainByID(String id){
        Optional<Complains> complain = complainRepo.findById(id);
        return complain.orElse(null);
    }

    public Complains checkedComplains(String id){
        Optional<Complains> complain = complainRepo.findById(id);
        if(complain.isEmpty()){
            return null;
        }
        Complains c = complain.get();
        c.setStatus(ComplainStage.CHECKED);
        return complainRepo.save(c);
    }

    public Complains solvedComplains(String id){
        Optional<Complains> complain = complainRepo.findById(id);
        if(complain.isEmpty()){
            return null;
        }
        Complains c = complain.get();
        c.setStatus(ComplainStage.SOLVED);
        return complainRepo.save(c);
    }

}
