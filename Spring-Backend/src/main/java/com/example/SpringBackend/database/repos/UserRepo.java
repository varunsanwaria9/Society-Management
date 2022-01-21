package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {

}
