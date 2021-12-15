package com.example.societybackend.databases.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class RegisterModel {

    private String first_name;
    private String last_name;
    private String gender;
    private String dob;
    private String phone;
    private String email;
    private String password;

    public RegisterModel() {
    }

    public RegisterModel(String first_name,
                         String last_name,
                         String gender,
                         String dob,
                         String phone,
                         String email,
                         String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.password = password;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
