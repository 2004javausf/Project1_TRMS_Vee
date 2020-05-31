package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dao.EMPDAOImpl;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TO DO Stuff
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost of EmployeeServlet");
		Employee emp=null;
		ObjectMapper mapper = new ObjectMapper();
		//convert JSON to Java Object
		emp=mapper.readValue(request.getInputStream(),Employee.class);
		EMPDAOImpl edi = new EMPDAOImpl();
		try {
			edi.insertEmployee(emp);
			PrintWriter pw = response.getWriter();
			pw.write("<h3> Added Employee Successfully!!!</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
