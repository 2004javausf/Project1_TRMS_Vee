package com.revature.beans;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 2524650933841857759L;
	
	private long empID;
	private String fName;
	private String lName;
	private String email;
	private String uName;
	private String uPassword;
	private String empTitle;
	private String empDept;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long empID, String fName, String lName, String email, String uName, String uPassword, String empTitle,
			String empDept) {
		super();
		this.empID = empID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.uName = uName;
		this.uPassword = uPassword;
		this.empTitle = empTitle;
		this.empDept = empDept;
	}



	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	


	@Override
	public String toString() {
		return "User [empID=" + empID + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", empTitle="
				+ empTitle + ", empDept=" + empDept + "]";
	}
	
	
}
