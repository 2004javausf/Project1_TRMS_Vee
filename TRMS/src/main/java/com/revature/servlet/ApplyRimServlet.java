package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;

import com.revature.dao.RIMDAOImpl;


public class ApplyRimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Reimbursement rim=null;
		ObjectMapper mapper = new ObjectMapper();
		//convert JSON to Java Object
		rim=mapper.readValue(request.getInputStream(),Reimbursement.class);
		RIMDAOImpl rdi = new RIMDAOImpl();
		try {
			rdi.insertRIM(rim);
			PrintWriter pw = response.getWriter();
			pw.write("<h3> Added Video Game Successfully!!!</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
