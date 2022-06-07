package com.example.SpringBackend.database.repos;

import com.example.SpringBackend.database.entities.Complains;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplainRepo extends JpaRepository<Complains, String> {

    @Query(value = "select * from complains where status ='RAISED' and residence_ref = ?1",nativeQuery = true)
    public List<Complains> getResidentComplainRaised(String id);

    @Query(value = "select * from complains where status = 'RAISED'",nativeQuery=true)
    public List<Complains> getAllRaisedComplains();
}
