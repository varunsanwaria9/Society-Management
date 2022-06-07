package com.example.SpringBackend.database.models;

public class BillAddModel {
	
	private String details;
	private long amount;
	private String flat_no;
	public BillAddModel(String details, long amount, String flat_no) {
		super();
		this.details = details;
		this.amount = amount;
		this.flat_no = flat_no;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getFlat_no() {
		return flat_no;
	}
	public void setFlat_no(String flat_no) {
		this.flat_no = flat_no;
	}
	
	@Override
	public String toString() {
		return "BillAddModel [details=" + details + ", amount=" + amount + ", flat_no=" + flat_no + "]";
	}
	
}
