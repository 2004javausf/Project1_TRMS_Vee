package com.revature.beans;

import java.sql.Date;

public class Reimbursement {
	
	private int rimID;             
    private int empID;     
    private float rimCOST;            
    private String rimSTATUS;    
	private String rimStatusBy;
	private String rimJustify; 
	private int daysMissed; 
	
	private int etID;
    private String etName;  
    private Date etDate;  
    private String etLocation;        
    private String etDesc;   
    private int etPercent;
    
    private int gfID;
    private String gfName;
    private String gfPassGrade;
    
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int rimID, int empID, float rimCOST, String rimSTATUS, String rimStatusBy, String rimJustify,
			int daysMissed, int eventTypeID, String eventType, Date eventDATE, String eventLOCATION, String eventDesc,
			int eventPercent, int gfID, String gfName, String gfPassGrade) {
		super();
		this.rimID = rimID;
		this.empID = empID;
		this.rimCOST = rimCOST;
		this.rimSTATUS = rimSTATUS;
		this.rimStatusBy = rimStatusBy;
		this.rimJustify = rimJustify;
		this.daysMissed = daysMissed;
		this.etID = eventTypeID;
		this.etName = eventType;
		this.etDate = eventDATE;
		this.etLocation = eventLOCATION;
		this.etDesc = eventDesc;
		this.etPercent = eventPercent;
		this.gfID = gfID;
		this.gfName = gfName;
		this.gfPassGrade = gfPassGrade;
	}

	public Reimbursement(int gfID, String gfName, String gfPassGrade) {
		super();
		this.gfID = gfID;
		this.gfName = gfName;
		this.gfPassGrade = gfPassGrade;
	}

	public Reimbursement(int eventTypeID, String eventType, int eventPercent) {
		super();
		this.etID = eventTypeID;
		this.etName = eventType;
		this.etPercent = eventPercent;
	}

	public int getRimID() {
		return rimID;
	}

	public void setRimID(int rimID) {
		this.rimID = rimID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public float getRimCOST() {
		return rimCOST;
	}

	public void setRimCOST(float rimCOST) {
		this.rimCOST = rimCOST;
	}

	public String getRimSTATUS() {
		return rimSTATUS;
	}

	public void setRimSTATUS(String rimSTATUS) {
		this.rimSTATUS = rimSTATUS;
	}

	public String getRimStatusBy() {
		return rimStatusBy;
	}

	public void setRimStatusBy(String rimStatusBy) {
		this.rimStatusBy = rimStatusBy;
	}

	public String getRimJustify() {
		return rimJustify;
	}

	public void setRimJustify(String rimJustify) {
		this.rimJustify = rimJustify;
	}

	public int getDaysMissed() {
		return daysMissed;
	}

	public void setDaysMissed(int daysMissed) {
		this.daysMissed = daysMissed;
	}

	public int getEventTypeID() {
		return etID;
	}

	public void setEventTypeID(int eventTypeID) {
		this.etID = eventTypeID;
	}

	public String getEventType() {
		return etName;
	}

	public void setEventType(String eventType) {
		this.etName = eventType;
	}

	public Date getEventDATE() {
		return etDate;
	}

	public void setEventDATE(Date eventDATE) {
		this.etDate = eventDATE;
	}

	public String getEventLOCATION() {
		return etLocation;
	}

	public void setEventLOCATION(String eventLOCATION) {
		this.etLocation = eventLOCATION;
	}

	public String getEventDesc() {
		return etDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.etDesc = eventDesc;
	}

	public int getEventPercent() {
		return etPercent;
	}

	public void setEventPercent(int eventPercent) {
		this.etPercent = eventPercent;
	}
	
	public int getGfID() {
		return gfID;
	}

	public void setGfID(int gfID) {
		this.gfID = gfID;
	}

	public String getGfName() {
		return gfName;
	}

	public void setGfName(String gfName) {
		this.gfName = gfName;
	}

	public String getGfPassGrade() {
		return gfPassGrade;
	}

	public void setGfPassGrade(String gfPassGrade) {
		this.gfPassGrade = gfPassGrade;
	}

	
	
	
	
	
    
    
    
    
      
	

}
