package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Workers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Workers, String> {
    
}
