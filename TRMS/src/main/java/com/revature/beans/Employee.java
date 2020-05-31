package com.revature.beans;

public class Employee {
	private String fName;
	private String lName;
	private String email;
	private String uName;
	private String uPassword;
	private int empTitle;
	private int empDept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String fName, String lName, String email, String uName, String uPassword, int empTitle,
			int empDept) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.uName = uName;
		this.uPassword = uPassword;
		this.empTitle = empTitle;
		this.empDept = empDept;
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

	public int getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(int empTitle) {
		this.empTitle = empTitle;
	}

	public int getEmpDept() {
		return empDept;
	}

	public void setEmpDept(int empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "Employee [fName=" + fName + ", lName=" + lName + ", email=" + email + ", uName=" + uName
				+ ", uPassword=" + uPassword + ", empTitle=" + empTitle + ", empDept=" + empDept + "]";
	}

}
