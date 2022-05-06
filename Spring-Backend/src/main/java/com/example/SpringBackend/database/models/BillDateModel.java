package com.example.SpringBackend.database.models;

public class BillDateModel {

    private String startDate;
    private String endDate;
    private String residence_ref;

    public BillDateModel(String startDate, String endDate, String residence_ref) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.residence_ref = residence_ref;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getResidence_ref() {
        return residence_ref;
    }

    public void setResidence_ref(String residence_ref) {
        this.residence_ref = residence_ref;
    }

    @Override
    public String toString() {
        return "BillDateModel{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", residence_ref='" + residence_ref + '\'' +
                '}';
    }
}
