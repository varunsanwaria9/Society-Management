package com.example.societybackend.databases.repos;

import com.example.societybackend.databases.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<Auth,String> {
    Optional<Auth> findByEmail(String email);
}
