package com.example.SpringBackend.database.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Residents {

    @Id
    @GeneratedValue
    private long resident_id;
    private String name;
    private String phone_no;
    private int residence_ref;
    private long portfolio_ref;
    @Column
    @ElementCollection(targetClass = Committee.class)
    private List<Committee> committee;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    public Residents() {
    }

    public Residents(String name, String phone_no, int residence_ref, long portfolio_ref, List<Committee> committee, Auth auth) {
        this.name = name;
        this.phone_no = phone_no;
        this.residence_ref = residence_ref;
        this.portfolio_ref = portfolio_ref;
        this.committee = committee;
        this.auth = auth;
    }
    
    public Residents(long resident_id, String name, String phone_no, int residence_ref, long portfolio_ref, List<Committee> committee, Auth auth) {
        this.resident_id = resident_id;
        this.name = name;
        this.phone_no = phone_no;
        this.residence_ref = residence_ref;
        this.portfolio_ref = portfolio_ref;
        this.committee = committee;
        this.auth = auth;
    }

    public long getResident_id() {
        return this.resident_id;
    }

    public void setResident_id(long resident_id) {
        this.resident_id = resident_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public int getResidence_ref() {
        return this.residence_ref;
    }

    public void setResidence_ref(int residence_ref) {
        this.residence_ref = residence_ref;
    }

    public long getPortfolio_ref() {
        return this.portfolio_ref;
    }

    public void setPortfolio_ref(long portfolio_ref) {
        this.portfolio_ref = portfolio_ref;
    }

    public List<Committee> getCommittee() {
        return this.committee;
    }

    public void setCommittee(List<Committee> committee) {
        this.committee = committee;
    }

    public Auth getAuth() {
        return this.auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "{" +
            " resident_id='" + getResident_id() + "'" +
            ", name='" + getName() + "'" +
            ", phone_no='" + getPhone_no() + "'" +
            ", residence_ref='" + getResidence_ref() + "'" +
            ", portfolio_ref='" + getPortfolio_ref() + "'" +
            ", committee='" + getCommittee() + "'" +
            ", auth='" + getAuth() + "'" +
            "}";
    }

    
}
