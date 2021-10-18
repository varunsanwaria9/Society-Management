package com.example.societybackend.databases.repos;

import com.example.societybackend.databases.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RolesRepo extends JpaRepository<Roles,String> {
}
