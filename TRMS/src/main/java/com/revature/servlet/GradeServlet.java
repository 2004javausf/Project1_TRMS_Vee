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
import com.revature.dao.RIMDAOImpl;


public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet od GradeServlet");
		ObjectMapper mapper = new ObjectMapper();
		RIMDAOImpl rdi = new RIMDAOImpl();
		PrintWriter pw = response.getWriter();
		String gfJSON;
		try {
			gfJSON=mapper.writeValueAsString(rdi.getGF());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(gfJSON);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}

}
