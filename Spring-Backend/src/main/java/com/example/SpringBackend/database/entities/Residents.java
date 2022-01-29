package com.example.SpringBackend.database.entities;

import java.util.List;
import javax.persistence.*;

@Entity
public class Residents {

    @Id
    @GeneratedValue
    private long resident_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone_no;
    @OneToOne
    @JoinColumn(name = "residence_ref")
    private Residences residence_ref;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_ref")
    private Portfolio portfolio;
    @Column
    @ElementCollection(targetClass = Committee.class)
    private List<Committee> committee;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_ref",nullable = false)
    private Auth auth;

    public Residents() {
    }

    public Residents(String name, String phone_no, Portfolio portfolio, List<Committee> committee, Auth auth) {
        this.name = name;
        this.phone_no = phone_no;
        this.portfolio = portfolio;
        this.committee = committee;
        this.auth = auth;
    }

    public Residents(long resident_id, String name, String phone_no, Residences residence_ref, Portfolio portfolio,
            List<Committee> committee, Auth auth) {
        this.resident_id = resident_id;
        this.name = name;
        this.phone_no = phone_no;
        this.residence_ref = residence_ref;
        this.portfolio = portfolio;
        this.committee = committee;
        this.auth = auth;
    }

    public long getResident_id() {
        return resident_id;
    }

    public void setResident_id(long resident_id) {
        this.resident_id = resident_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public Residences getResidence_ref() {
        return residence_ref;
    }

    public void setResidence_ref(Residences residence_ref) {
        this.residence_ref = residence_ref;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<Committee> getCommittee() {
        return committee;
    }

    public void setCommittee(List<Committee> committee) {
        this.committee = committee;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "Residents [auth=" + auth + ", committee=" + committee + ", name=" + name + ", phone_no=" + phone_no
                + ", portfolio=" + portfolio + ", residence_ref=" + residence_ref + ", resident_id=" + resident_id
                + "]";
    }
    
}
