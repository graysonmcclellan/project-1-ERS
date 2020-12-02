package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.service.AuthenticationService;


public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//FIRST return the login page for GET requests
		request.getRequestDispatcher("login.html").forward(request, response);
		

		
	}

	//Performs authentication for post requests
	//Get info to store in Session in the post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//creates new session 
		HttpSession session = request.getSession();
		
		
		//returning the info we collect from user
		response.setContentType("text/html");
		
		
		
		//collect parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		//checks in Authentication Service is username/pasword exist in database
		if(AuthenticationService.isValidUser(username, password)) {
			//Store the username and password in the Session
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			
			//response.sendRedirect("profile");
			
			
			User currUser = AuthenticationService.getCurrentUserByUsername(username);
			
			session.setAttribute("userId", currUser.getUserId());
			session.setAttribute("firstName", currUser.getFirstName());
			session.setAttribute("lastName", currUser.getLastName());

			session.setAttribute("roleId", currUser.getRole().getRoleId());
			if(session.getAttribute("roleId").equals(1)) {
				
				response.sendRedirect("profile");

			}else {
				response.sendRedirect("admin");
			}

			
		}else {
			
			//sned alert back need to learn how to do this
			
			response.sendRedirect("login");
		}
	
		
		//would need to check for authenticity and redirect here!!!
		
		
	
		
		
		
		
		
	
	}

}
