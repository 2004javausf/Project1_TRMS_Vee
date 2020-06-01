package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.dao.RIMDAOImpl;

public class UpdateStatusServer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		User user = new User();
		user = (User) LoginServlet.session.getAttribute("user");
		System.out.println(user);
		
		String eTitle = user.getEmpTitle();
		
		String id=request.getParameter("rimID");
		String status=request.getParameter("eStatus");
		String statusby=request.getParameter("eStatusBy");
		String notes=request.getParameter("eNotes");
		
		statusby=eTitle;
		
		RIMDAOImpl rdi = new RIMDAOImpl();
		
		try {
			rdi.updateStatus(id,status,statusby,notes);
			pw.write("<h3> Added Reimbursement Successfully!!!</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
