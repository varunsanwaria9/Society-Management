package com.example.SpringBackend.database.repos;

import java.util.List;
import java.util.Optional;

import com.example.SpringBackend.database.entities.Residences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResidenceRepo extends JpaRepository<Residences, String> {

    @Query(value = "select * from Residences r where r.tower_ref = ?1", 
            nativeQuery = true)
    List<Residences> findByTower(int towerId);

    @Query(value = "select * from residences where tower_ref = ?1 and floor_no = ?2", 
            nativeQuery = true)
    List<Residences> findByTowerAndFloor(int towerId, int floorNo);

    @Query(value = "select * from residences where floor_no = ?1", 
            nativeQuery = true)
	List<Residences> findByFloor(int floorNo);

	@Query(value = "select * from residences where flat_no = ?1", 
			nativeQuery = true)
	Optional<Residences> findByFlatNo(String flatNo);
        
}
