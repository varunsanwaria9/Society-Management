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

    public Supervisor getSupervisorById(long id) throws Exception{
        Optional<Supervisor> supervisor = supervisorRepo.findById(id);
        if (supervisor.isEmpty()) throw new Exception("No Supervisor found");
        return supervisor.get();
    }

    public Supervisor getSupervisorByEmail(String email) throws Exception{
        Optional<Supervisor> supervisor = supervisorRepo.findByEmail(email);
        if(supervisor.isEmpty()) throw new Exception("No supervisor found");
        return supervisor.get();
    }

    public Supervisor updateSupervisor(Supervisor supervisor){
        return supervisorRepo.save(supervisor);
    }

    public void deleteSupervisor(long id) throws Exception {
        Optional<Supervisor> supervisor = supervisorRepo.findById(id);
        if(supervisor.isEmpty()) throw new Exception("No supervisor found");
        supervisorRepo.delete(supervisor.get());
    }
}
