package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Auth, Long> {

    
}
