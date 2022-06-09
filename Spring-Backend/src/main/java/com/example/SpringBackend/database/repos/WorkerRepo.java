package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Workers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkerRepo extends JpaRepository<Workers, String> {

	@Query(value = "select * from workers where tower_ref = ?1",nativeQuery = true)
	List<Workers> getWorkersByTower(String towerRef);
}
