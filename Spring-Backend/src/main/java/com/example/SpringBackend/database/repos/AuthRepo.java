package com.example.SpringBackend.database.repos;

import java.util.Optional;

import com.example.SpringBackend.database.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Auth, String> {

    Optional<Auth> findByEmail(String email);

    
}
