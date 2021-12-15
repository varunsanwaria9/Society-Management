package com.example.societybackend.databases.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.societybackend.databases.enums.Helper;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Helpers{
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String id;
	private String first_name;
	private String last_name;
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> flat_no;
	private Helper helper;

	public Helpers(){}

	public Helpers(String first_name, String last_name, List<String> flat_no, Helper helper) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.flat_no = flat_no;
		this.helper = helper;
	}
	
	public Helpers(String id, String first_name, String last_name, List<String> flat_no, Helper helper) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.flat_no = flat_no;
		this.helper = helper;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public List<String> getFlat_no() {
		return flat_no;
	}
	
	public void setFlat_no(List<String> flat_no) {
		this.flat_no = flat_no;
	}
	
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}

}
