package com.example.SpringBackend.database.entities;

import javax.persistence.*;

@Entity
public class Bills {
    
    @Id
    @GeneratedValue
    private long bill_id;
    private String details;
    private long amount;
    private String status;
    private String paid_on;
    private int residence_ref;

    public Bills() {
    }

    public Bills(String details, long amount, String status, String paid_on, int residence_ref) {
        this.details = details;
        this.amount = amount;
        this.status = status;
        this.paid_on = paid_on;
        this.residence_ref = residence_ref;
    }

    public Bills(long bill_id, String details, long amount, String status, String paid_on, int residence_ref) {
        this.bill_id = bill_id;
        this.details = details;
        this.amount = amount;
        this.status = status;
        this.paid_on = paid_on;
        this.residence_ref = residence_ref;
    }

    public long getBill_id() {
        return this.bill_id;
    }

    public void setBill_id(long bill_id) {
        this.bill_id = bill_id;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaid_on() {
        return this.paid_on;
    }

    public void setPaid_on(String paid_on) {
        this.paid_on = paid_on;
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
            " bill_id='" + getBill_id() + "'" +
            ", details='" + getDetails() + "'" +
            ", amount='" + getAmount() + "'" +
            ", status='" + getStatus() + "'" +
            ", paid_on='" + getPaid_on() + "'" +
            ", residence_ref='" + getResidence_ref() + "'" +
            "}";
    }

}
