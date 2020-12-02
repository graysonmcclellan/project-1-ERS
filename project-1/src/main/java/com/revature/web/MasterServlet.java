package com.revature.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in master servlet...");
		final String URI = request.getRequestURI();

		switch (URI) {
		case "login":
			System.out.println("In login case...");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");// we want to send our user to the home page!
			rd.forward(request, response);
			//RequestHelper.processLogin(request, response);
			break;
//		case "logout":
//			RequestHelper.processLogout(request, response);
//			break;
//		case "employees":
//			RequestHelper.processEmployees(request, response);
//			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
