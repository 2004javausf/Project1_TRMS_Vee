package com.revature.beans;

public class EmpTitle {
	private int titleID;
	private String titleName;
	
	public EmpTitle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpTitle(int titleID, String titleName) {
		super();
		this.titleID = titleID;
		this.titleName = titleName;
	}

	public int getTitleID() {
		return titleID;
	}

	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Override
	public String toString() {
		return "EmpTitle [titleID=" + titleID + ", titleName=" + titleName + "]";
	}
	
}
