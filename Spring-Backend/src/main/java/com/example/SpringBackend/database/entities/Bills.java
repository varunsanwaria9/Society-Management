package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.BillStage;

@Entity
public class Bills {
    
    @Id
    @GeneratedValue
    private long bill_id;
    private String details;
    private long amount;
    private BillStage status;
    private String paid_on;
    @OneToOne
    @JoinColumn(name = "residence_ref")
    private Residences residence_ref;

    public Bills() {
    }

    public Bills(String details, long amount, BillStage status, String paid_on) {
        this.details = details;
        this.amount = amount;
        this.status = status;
        this.paid_on = paid_on;
    }

    public Bills(long bill_id, String details, long amount, BillStage status, String paid_on, Residences residence_ref) {
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

    public BillStage getStatus() {
        return this.status;
    }

    public void setStatus(BillStage status) {
        this.status = status;
    }

    public String getPaid_on() {
        return this.paid_on;
    }

    public void setPaid_on(String paid_on) {
        this.paid_on = paid_on;
    }

    public Residences getResidence_ref() {
        return residence_ref;
    }

    public void setResidence_ref(Residences residence_ref) {
        this.residence_ref = residence_ref;
    }

    @Override
    public String toString() {
        return "Bills [amount=" + amount + ", bill_id=" + bill_id + ", details=" + details + ", paid_on=" + paid_on
                + ", residence_ref=" + residence_ref + ", status=" + status + "]";
    }

}
