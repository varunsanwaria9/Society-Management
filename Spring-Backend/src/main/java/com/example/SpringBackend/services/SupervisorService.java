package com.example.SpringBackend.services;

import com.example.SpringBackend.database.entities.Supervisor;
import com.example.SpringBackend.database.repos.SupervisorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {

    @Autowired
    private SupervisorRepo supervisorRepo;

    public Supervisor addSupervisor(Supervisor supervisor){
        return supervisorRepo.save(supervisor);
    }

    public List<Supervisor> getAllSupervisor(){
        return supervisorRepo.findAll();
    }

    public Supervisor getSupervisorById(String id){
        Optional<Supervisor> supervisor = supervisorRepo.findById(id);
        return supervisor.orElse(null);
    }

    public Supervisor getSupervisorByEmail(String email){
        Optional<Supervisor> supervisor = supervisorRepo.findByEmail(email);
        return supervisor.orElse(null);
    }

    public Supervisor updateSupervisor(Supervisor supervisor){
        return supervisorRepo.save(supervisor);
    }

    public void deleteSupervisor(String id) throws Exception {
        Optional<Supervisor> supervisor = supervisorRepo.findById(id);
        if(supervisor.isEmpty()) throw new Exception("No supervisor found");
        supervisorRepo.delete(supervisor.get());
    }
}
