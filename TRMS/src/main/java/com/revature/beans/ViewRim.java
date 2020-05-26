package com.revature.beans;
import java.sql.Date;

public class ViewRim {
	             
    private String empName;     
    private double rimCOST;            
    private String etName;  
    private Date etDate;  
    private String etLocation;        
    private String etDesc;
    private String eGrade;
    private String rimJustify; 
	private int daysMissed; 
    private String rimSTATUS;    
   	private String rimStatusBy;
   	
	public ViewRim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewRim(String empName, double rimCOST, String etName, Date etDate, String etLocation, String etDesc, String eGrade,
			String rimJustify, int daysMissed, String rimSTATUS, String rimStatusBy) {
		super();
		this.empName = empName;
		this.rimCOST = rimCOST;
		this.etName = etName;
		this.etDate = etDate;
		this.etLocation = etLocation;
		this.etDesc = etDesc;
		this.eGrade = eGrade;
		this.rimJustify = rimJustify;
		this.daysMissed = daysMissed;
		this.rimSTATUS = rimSTATUS;
		this.rimStatusBy = rimStatusBy;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getRimCOST() {
		return rimCOST;
	}

	public void setRimCOST(double rimCOST) {
		this.rimCOST = rimCOST;
	}

	public String getEtName() {
		return etName;
	}

	public void setEtName(String etName) {
		this.etName = etName;
	}

	public Date getEtDate() {
		return etDate;
	}

	public void setEtDate(Date etDate) {
		this.etDate = etDate;
	}

	public String getEtLocation() {
		return etLocation;
	}

	public void setEtLocation(String etLocation) {
		this.etLocation = etLocation;
	}

	public String getEtDesc() {
		return etDesc;
	}

	public void setEtDesc(String etDesc) {
		this.etDesc = etDesc;
	}
	
	public String geteGrade() {
		return eGrade;
	}

	public void seteGrade(String eGrade) {
		this.eGrade = eGrade;
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

	@Override
	public String toString() {
		return "ViewRim [empName=" + empName + ", rimCOST=" + rimCOST + ", etName=" + etName + ", etDate=" + etDate
				+ ", etLocation=" + etLocation + ", etDesc=" + etDesc + ", rimJustify="
				+ rimJustify + ", daysMissed=" + daysMissed + ", rimSTATUS=" + rimSTATUS + ", rimStatusBy="
				+ rimStatusBy + "]";
	}
   	
   	

}
