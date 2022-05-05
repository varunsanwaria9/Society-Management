package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ManagerRepo extends JpaRepository<Managers, String> {

    @Query(value = "select m.* from managers m,auth a where m.auth_id = a.auth_id and a.email = ?1",nativeQuery = true)
    Optional<Managers> findByEmail(String email);
}
