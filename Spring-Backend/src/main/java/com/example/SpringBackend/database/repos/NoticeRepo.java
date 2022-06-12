package com.example.SpringBackend.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBackend.database.entities.Notice;

public interface NoticeRepo extends JpaRepository<Notice, String> {

}
