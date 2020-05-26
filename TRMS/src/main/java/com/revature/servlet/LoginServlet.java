package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Login;
import com.revature.beans.User;
import com.revature.dao.LoginDAOImpl;
import com.revature.dao.RIMDAOImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("home.html").include(request, response);
		
		String uName=request.getParameter("uName");
		String password=request.getParameter("uPassword");
		System.out.println("Roll Tide in doPost Login");
		System.out.println(uName + " " + password);
		
		RIMDAOImpl rdi = new RIMDAOImpl();
		User user = new User();
		try {
			user = rdi.getLogInUser(uName,password);
			System.out.println(user);
			String name = user.getfName() + " " + user.getlName();
			if(password.equals(user.getuPassword())) {
				out.print("Welcome, "+name);
				HttpSession session=request.getSession();
				session.setAttribute("name",name);
			}else {
				out.print("Sorry, username or password invalid!!!");
				request.getRequestDispatcher("index.html").include(request, response);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}
}
