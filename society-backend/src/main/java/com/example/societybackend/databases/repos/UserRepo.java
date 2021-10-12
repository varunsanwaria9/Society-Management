package com.example.societybackend.databases.repos;

import com.example.societybackend.databases.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,String> {
}
