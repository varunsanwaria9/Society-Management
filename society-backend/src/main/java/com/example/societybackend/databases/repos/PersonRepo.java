package com.example.societybackend.databases.repos;

import com.example.societybackend.databases.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,String> {
}
