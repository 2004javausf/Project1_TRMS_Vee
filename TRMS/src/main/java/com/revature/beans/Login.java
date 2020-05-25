package com.revature.beans;

import java.io.Serializable;

public class Login implements Serializable {
	
	private static final long serialVersionUID = 6923796426546348788L;
	
	private String uName;
	private String uPassword;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Login(String uName, String uPassword) {
		super();
		this.uName = uName;
		this.uPassword = uPassword;
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
	
	

}
