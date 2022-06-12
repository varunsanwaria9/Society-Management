package com.example.SpringBackend.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Notice {
	
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String notice_id;
    private String details;
    private String created_on;
	
    public Notice() {
    	
    }
    public Notice(String details, String created_on) {
		this.details = details;
		this.created_on = created_on;
	}

	public Notice(String notice_id, String details, String created_on) {
		this.notice_id = notice_id;
		this.details = details;
		this.created_on = created_on;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", details=" + details + ", created_on=" + created_on + "]";
	}
    
    
}
