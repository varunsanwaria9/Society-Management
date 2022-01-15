package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Supervisor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepo extends JpaRepository<Supervisor, Integer> {
    
}
