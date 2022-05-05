package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SupervisorRepo extends JpaRepository<Supervisor, String> {

    @Query(value = "select s.* from supervisor s,auth a where s.auth_id = a.auth_id and a.email = ?1",nativeQuery = true)
    Optional<Supervisor> findByEmail(String email);

}
