package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.dao.RIMDAOImpl;

public class ViewAllRimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of viewAllRimServlet");
		ObjectMapper mapper = new ObjectMapper();
		RIMDAOImpl rdi = new RIMDAOImpl();
		PrintWriter pw = response.getWriter();
		String etJSON;
		User user = new User();
		user = (User) LoginServlet.session.getAttribute("user");
		System.out.println(user);
		
		long eID = user.getEmpID();
		String eTitle = user.getEmpTitle();
		String eDept = user.getEmpDept();
		
		try {
			etJSON=mapper.writeValueAsString(rdi.getViewAllRim(eID,eTitle,eDept));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(etJSON);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
