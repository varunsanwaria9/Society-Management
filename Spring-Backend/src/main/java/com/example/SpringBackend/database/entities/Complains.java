package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.ComplainStage;

@Entity
public class Complains {
    
    @Id
    @GeneratedValue
    private long complain_id;
    private String details;
    private String raised_on;
    private ComplainStage status;
    private int residence_ref;

    public Complains() {
    }

    public Complains(String details, String raised_on, ComplainStage status, int residence_ref) {
        this.details = details;
        this.raised_on = raised_on;
        this.status = status;
        this.residence_ref = residence_ref;
    }

    public Complains(long complain_id, String details, String raised_on, ComplainStage status, int residence_ref) {
        this.complain_id = complain_id;
        this.details = details;
        this.raised_on = raised_on;
        this.status = status;
        this.residence_ref = residence_ref;
    }


    public long getComplain_id() {
        return this.complain_id;
    }

    public void setComplain_id(long complain_id) {
        this.complain_id = complain_id;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRaised_on() {
        return this.raised_on;
    }

    public void setRaised_on(String raised_on) {
        this.raised_on = raised_on;
    }

    public ComplainStage getStatus() {
        return this.status;
    }

    public void setStatus(ComplainStage status) {
        this.status = status;
    }

    public int getResidence_ref() {
        return this.residence_ref;
    }

    public void setResidence_ref(int residence_ref) {
        this.residence_ref = residence_ref;
    }

    @Override
    public String toString() {
        return "{" +
            " complain_id='" + getComplain_id() + "'" +
            ", details='" + getDetails() + "'" +
            ", raised_on='" + getRaised_on() + "'" +
            ", status='" + getStatus() + "'" +
            ", residence_ref='" + getResidence_ref() + "'" +
            "}";
    }

}
