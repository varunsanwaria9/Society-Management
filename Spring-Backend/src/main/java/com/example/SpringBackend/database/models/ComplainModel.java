
package com.example.SpringBackend.database.models;

public class ComplainModel {

	private String value;
	private String ref;
	
	public ComplainModel(String value, String ref) {
		super();
		this.value = value;
		this.ref = ref;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "ComplainModel [value=" + value + ", ref=" + ref + "]";
	}
	
}
