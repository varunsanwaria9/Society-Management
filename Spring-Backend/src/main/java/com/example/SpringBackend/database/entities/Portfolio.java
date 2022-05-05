package com.example.SpringBackend.database.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String portfolio_id;
    private String post;
    private int tenure;


    public Portfolio() {
    }

    public Portfolio(String post, int tenure) {
        this.post = post;
        this.tenure = tenure;
    }

    public Portfolio(String portfolio_id, String post, int tenure) {
        this.portfolio_id = portfolio_id;
        this.post = post;
        this.tenure = tenure;
    }


    public String getPortfolio_id() {
        return this.portfolio_id;
    }

    public void setPortfolio_id(String portfolio_id) {
        this.portfolio_id = portfolio_id;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getTenure() {
        return this.tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }


    @Override
    public String toString() {
        return "{" +
            " portfolio_id='" + getPortfolio_id() + "'" +
            ", post='" + getPost() + "'" +
            ", tenure='" + getTenure() + "'" +
            "}";
    }

}
