package com.example.SpringBackend.services;

import com.example.SpringBackend.database.entities.Managers;
import com.example.SpringBackend.database.repos.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;

    public Managers addManager(Managers manager){
        return managerRepo.save(manager);
    }

    public List<Managers> getAllManagers(){
        return managerRepo.findAll();
    }

    public Managers getManagerById(String id){
        Optional<Managers> managers = managerRepo.findById(id);
        return managers.orElse(null);
    }

    public Managers getManagerByEmail(String email) throws Exception {
        Optional<Managers> managers = managerRepo.findByEmail(email);
        if(managers.isEmpty()) throw new Exception("No manager found");
        return managers.get();
    }

    public Managers updateManagers(Managers managers){
        return managerRepo.save(managers);
    }

    public void deleteManager(String id) throws Exception {
        Optional<Managers> managers = managerRepo.findById(id);
        if(managers.isEmpty()) throw new Exception("No manager found");
        managerRepo.delete(managers.get());
    }
}
