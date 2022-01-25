package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Complains;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepo extends JpaRepository<Complains, Long> {

    
}
