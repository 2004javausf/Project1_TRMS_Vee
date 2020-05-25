package com.revature.beans;

import java.sql.Date;

public class EventType {
	private int etID;
    private String etName;  
    private int etPercent;
    
	public EventType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EventType(int etID, String etName, int etPercent) {
		super();
		this.etID = etID;
		this.etName = etName;
		this.etPercent = etPercent;
	}

	public int getEtID() {
		return etID;
	}

	public void setEtID(int etID) {
		this.etID = etID;
	}

	public String getEtName() {
		return etName;
	}

	public void setEtName(String etName) {
		this.etName = etName;
	}

	public int getEtPercent() {
		return etPercent;
	}

	public void setEtPercent(int etPercent) {
		this.etPercent = etPercent;
	}
    
    
    
    
}
