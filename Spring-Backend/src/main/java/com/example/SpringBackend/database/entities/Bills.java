package com.example.SpringBackend.database.entities;

import javax.persistence.*;

import com.example.SpringBackend.database.enums.BillStage;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Bills {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String bill_id;
    @Column(nullable = false)
    private String details;
    @Column(nullable = false)
    private long amount;
    @Enumerated(EnumType.STRING)
    private BillStage status;
    private String generated_on;
    private String paid_on;
    @OneToOne
    @JoinColumn(name = "residence_ref")
    private Residences residence_ref;

    public Bills() {
    }

    public Bills(String details, long amount, BillStage status, String generated_on, String paid_on) {
        this.details = details;
        this.amount = amount;
        this.status = status;
        this.generated_on = generated_on;
        this.paid_on = paid_on;
    }

    public Bills(String bill_id, String details, long amount, BillStage status, String generated_on, String paid_on, Residences residence_ref) {
        this.bill_id = bill_id;
        this.details = details;
        this.amount = amount;
        this.status = status;
        this.generated_on = generated_on;
        this.paid_on = paid_on;
        this.residence_ref = residence_ref;
    }

    public String getBill_id() {
        return this.bill_id;
    }

    public void setBill_id(String bill_id) {
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

    public String getGenerated_on() {
        return generated_on;
    }

    public void setGenerated_on(String generated_on) {
        this.generated_on = generated_on;
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
