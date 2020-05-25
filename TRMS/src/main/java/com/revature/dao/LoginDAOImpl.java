package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.User;
import com.revature.util.ConnFactory;

public class LoginDAOImpl {

public static ConnFactory banana = ConnFactory.getInstance();
	
	//get specific
	
	public User getLogInUser(String uName) throws SQLException {
		User user=null;
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_USERNAME="+ uName);
		
		while(rs.next()) {
			user=new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),"","");
			
			ResultSet et=stmt.executeQuery("SELECT EMPLOYEE_TITLE_NAME FROM EMPLOYEE_TITLE WHERE EMPLOYEE_TITLE_ID= "+ rs.getLong(7));
			while(et.next()) {
				user.setEmpTitle(et.getString(1));
			}
			ResultSet ed=stmt.executeQuery("SELECT DEPARTMENT_NAME FROM DEPARTMENT WHERE DEPARTMENT_ID= "+ rs.getLong(8));			
			while(ed.next()) {
				user.setEmpDept(ed.getString(1));
			}
		}
		
		System.out.println(user);
		
		return user;
	}	
	
}
