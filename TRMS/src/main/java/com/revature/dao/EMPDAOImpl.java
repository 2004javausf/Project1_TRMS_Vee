package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.util.ConnFactory;

public class EMPDAOImpl {
	
	public static ConnFactory banana = ConnFactory.getInstance();
	
	//insert reimbursement
	public void insertEmployee(Employee emp) throws SQLException {
		Connection conn = banana.getConnection();
		double bal=1000.00;
		String sql = "INSERT INTO EMPLOYEE (EMPLOYEE_FIRSTNAME,EMPLOYEE_LASTNAME, EMPLOYEE_EMAIL,EMPLOYEE_USERNAME,EMPLOYEE_PASSWORD,EMPLOYEE_TITLE,EMPLOYEE_DEPARTMENT,EMPLOYEE_BALANCE) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, emp.getfName());
		ps.setString(2, emp.getlName());
		ps.setString(3, emp.getEmail());
		ps.setString(4, emp.getuName());
		ps.setString(5, emp.getuPassword());
		ps.setInt(6, emp.getEmpTitle());
		ps.setInt(7, emp.getEmpDept());
		ps.setDouble(8, bal);
		
		ps.executeUpdate();
	}
	
	//get users info to verify login
		public List<User> getLogInUser() throws SQLException {
			List<User> uList=new ArrayList<User>();
			User user=null;
			Connection conn = banana.getConnection();
			Statement stmt=conn.createStatement();
			String sql = ("SELECT EMPLOYEE.EMPLOYEE_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME,EMPLOYEE.EMPLOYEE_LASTNAME,EMPLOYEE.EMPLOYEE_EMAIL,EMPLOYEE.EMPLOYEE_USERNAME,EMPLOYEE.EMPLOYEE_PASSWORD," + 
					"EMPLOYEE_TITLE.EMPLOYEE_TITLE_NAME,DEPARTMENT.DEPARTMENT_NAME,EMPLOYEE_BALANCE FROM EMPLOYEE " + 
					"JOIN EMPLOYEE_TITLE " + 
					"ON EMPLOYEE.EMPLOYEE_TITLE = EMPLOYEE_TITLE.EMPLOYEE_TITLE_ID " + 
					"JOIN DEPARTMENT " + 
					"ON EMPLOYEE.EMPLOYEE_DEPARTMENT=DEPARTMENT.DEPARTMENT_ID");
			
			System.out.println(sql);
			
			ResultSet rs=stmt.executeQuery(sql);
			
			System.out.println(rs);
			
			while(rs.next()) {
				
				user=new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDouble(9));
				uList.add(user);
			}
			
			return uList;
		}
		
}
