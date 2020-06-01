package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.RIMDAOImpl;

public class UpdateGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String id=request.getParameter("rimID");
		String grade=request.getParameter("eGrade");
		
		RIMDAOImpl rdi = new RIMDAOImpl();
		
		try {
			rdi.updateGrade(id,grade);
			pw.write("<h3> Added Reimbursement Successfully!!!</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
