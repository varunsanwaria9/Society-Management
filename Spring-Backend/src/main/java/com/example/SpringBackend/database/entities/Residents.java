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
    private int resident_ref;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
    @Column
    @ElementCollection(targetClass = Committee.class)
    private List<Committee> committee;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    public Residents() {
    }

    public Residents(String name, String phone_no, int resident_ref, Portfolio portfolio, List<Committee> committee, Auth auth) {
        this.name = name;
        this.phone_no = phone_no;
        this.resident_ref = resident_ref;
        this.portfolio = portfolio;
        this.committee = committee;
        this.auth = auth;
    }
    
    public Residents(long resident_id, String name, String phone_no, int resident_ref, Portfolio portfolio, List<Committee> committee, Auth auth) {
        this.resident_id = resident_id;
        this.name = name;
        this.phone_no = phone_no;
        this.resident_ref = resident_ref;
        this.portfolio = portfolio;
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

    public int getResident_ref() {
        return this.resident_ref;
    }

    public void setResident_ref(int resident_ref) {
        this.resident_ref = resident_ref;
    }

    public Portfolio getPortfolio() {
        return this.portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
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
            ", resident_ref='" + getResident_ref() + "'" +
            ", portfolio='" + getPortfolio() + "'" +
            ", committee='" + getCommittee() + "'" +
            ", auth='" + getAuth() + "'" +
            "}";
    }
    
}
