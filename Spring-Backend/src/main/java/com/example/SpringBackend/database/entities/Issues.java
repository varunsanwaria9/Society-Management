package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Issues {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long issue_id;
    private String issue_details;
    private String raised_on;
    private Long raised_by;
    private String issue_status;

    public Issues() {
    }

    public Issues(String issue_details, String raised_on, Long raised_by, String issue_status) {
        this.issue_details = issue_details;
        this.raised_on = raised_on;
        this.raised_by = raised_by;
        this.issue_status = issue_status;
    }

    public Issues(long issue_id, String issue_details, String raised_on, Long raised_by, String issue_status) {
        this.issue_id = issue_id;
        this.issue_details = issue_details;
        this.raised_on = raised_on;
        this.raised_by = raised_by;
        this.issue_status = issue_status;
    }
   

    public long getIssue_id() {
        return this.issue_id;
    }

    public void setIssue_id(long issue_id) {
        this.issue_id = issue_id;
    }

    public String getIssue_details() {
        return this.issue_details;
    }

    public void setIssue_details(String issue_details) {
        this.issue_details = issue_details;
    }

    public String getRaised_on() {
        return this.raised_on;
    }

    public void setRaised_on(String raised_on) {
        this.raised_on = raised_on;
    }

    public Long getRaised_by() {
        return this.raised_by;
    }

    public void setRaised_by(Long raised_by) {
        this.raised_by = raised_by;
    }

    public String getIssue_status() {
        return this.issue_status;
    }

    public void setIssue_status(String issue_status) {
        this.issue_status = issue_status;
    }

    @Override
    public String toString() {
        return "{" +
            " issue_id='" + getIssue_id() + "'" +
            ", issue_details='" + getIssue_details() + "'" +
            ", raised_on='" + getRaised_on() + "'" +
            ", raised_by='" + getRaised_by() + "'" +
            ", issue_status='" + getIssue_status() + "'" +
            "}";
    }

}
