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
	
	public User getLogInUser(String uName, String uPassword) throws SQLException {
		User user=null;
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		String sql = ("SELECT * FROM EMPLOYEE " + 
				"WHERE EMPLOYEE_USERNAME="+uName+" AND EMPLOYEE_PASSWORD="+ uPassword);
		System.out.println(sql);
		ResultSet rs=stmt.executeQuery(sql);
		
		System.out.println(rs);
		
		while(rs.next()) {
			user=new User(rs.getLong(1),rs.getString(2),rs.getString(3),uName,uPassword,rs.getLong(7),rs.getLong(8));
			
		}
		
		System.out.println(user);
		
		return user;
	}	
	
}
