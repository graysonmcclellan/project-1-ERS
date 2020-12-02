package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.UserService;

/**
 * Servlet implementation class UserCreated
 */
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("newUser.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creates new session 
		HttpSession session = request.getSession();
		

		//collect parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		//call service to create a new user from the users input in the database
		UserService us = new UserService();
		
		//create new user object
		User curr = new User(username, password, firstName, lastName, new Role(1, "Employee"));
		
		//call method on service
		us.addUser(curr);
		
		//redirects back to index
		response.sendRedirect("welcome");

		
		
		
	}

}
