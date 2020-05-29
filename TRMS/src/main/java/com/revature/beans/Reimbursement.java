package com.revature.beans;

import java.sql.Date;
import java.sql.Time;

public class Reimbursement {
	
	private long eID;
	private String fName;
	private String lName;
	private double tFees;
	private int eType;
	private Date eDate;
	private Time eTime;
	private String location;
	private String desc;
	private int gFormat;
	private String justifi;
	private int mDays;
	private double rprojected;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(long eID, String fName, String lName, double tFees, int eType, Date eDate, Time eTime,
			String location, String desc, int gFormat, String justifi, int mDays, double rprojected) {
		super();
		this.eID = eID;
		this.fName = fName;
		this.lName = lName;
		this.tFees = tFees;
		this.eType = eType;
		this.eDate = eDate;
		this.eTime = eTime;
		this.location = location;
		this.desc = desc;
		this.gFormat = gFormat;
		this.justifi = justifi;
		this.mDays = mDays;
		this.rprojected = rprojected;
	}
	public long geteID() {
		return eID;
	}
	public void seteID(long eID) {
		this.eID = eID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public double gettFees() {
		return tFees;
	}
	public void settFees(double tFees) {
		this.tFees = tFees;
	}
	public int geteType() {
		return eType;
	}
	public void seteType(int eType) {
		this.eType = eType;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public Time geteTime() {
		return eTime;
	}
	public void seteTime(Time eTime) {
		this.eTime = eTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getgFormat() {
		return gFormat;
	}
	public void setgFormat(int gFormat) {
		this.gFormat = gFormat;
	}
	public String getJustifi() {
		return justifi;
	}
	public void setJustifi(String justifi) {
		this.justifi = justifi;
	}
	public int getMDays() {
		return mDays;
	}
	public void setMDays(int mDays) {
		this.mDays = mDays;
	}
	public double getRprojected() {
		return rprojected;
	}
	public void setRprojected(double rprojected) {
		this.rprojected = rprojected;
	}
	@Override
	public String toString() {
		return "Reimbursement [eID=" + eID + ", fName=" + fName + ", lName=" + lName + ", tFees=" + tFees + ", eType="
				+ eType + ", eDate=" + eDate + ", eTime=" + eTime + ", location=" + location + ", desc=" + desc
				+ ", gFormat=" + gFormat + ", justifi=" + justifi + ", wDays=" + mDays + ", rprojected=" + rprojected
				+ "]";
	}
	
	
    
      
	

}
