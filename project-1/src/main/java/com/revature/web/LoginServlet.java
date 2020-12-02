package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.LoginTemplate;
import com.revature.model.User;
import com.revature.service.AuthenticationService;

//import com.revature.util.RequestHelper;

public class LoginServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoginServlet.class);
	private static ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// FIRST return the login page for GET requests
		request.getRequestDispatcher("login.html").forward(request, response);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// we are just transferring our Reader data to our StringBuilder, line by line
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = s.toString();
		System.out.println(body);

		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		log.info("User attempted to login with username " + username);

		// checks in Authentication Service is username/pasword exist in database
		if (AuthenticationService.isValidUser(username, password)) {
			
			System.out.println("Somehow inside the valid user");
			HttpSession session = req.getSession();
			// Store the username and password in the Session
			session.setAttribute("username", username);
			session.setAttribute("password", password);

			// response.sendRedirect("profile");

			User currUser = AuthenticationService.getCurrentUserByUsername(username);

			session.setAttribute("userId", currUser.getUserId());
			session.setAttribute("firstName", currUser.getFirstName());
			session.setAttribute("lastName", currUser.getLastName());

			session.setAttribute("roleId", currUser.getRole().getRoleId());
			
			
			System.out.println(currUser);
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(currUser));
			
			
			
//			if (session.getAttribute("roleId").equals(1)) {
//
//				res.sendRedirect("profile");
//
//			} else {
//				res.sendRedirect("admin");
//			}
//
		} else {
			
			res.setStatus(204);// this means that the connection was successful but no user found!
	

			//res.sendRedirect("login");
		}
		//res.setStatus(204);

	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out.");
			session.invalidate();
		}

		res.setStatus(200);
	}

//	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		res.setContentType("application/json");
//		
//		List<Employee> all = EmployeeService.findAll();
//		List<EmployeeDTO> allDTO = new ArrayList<>();
//		
//		for (Employee e : all) {
//			allDTO.add(EmployeeService.convertToDTO(e));
//		}
//		
//		String json = om.writeValueAsString(allDTO);
//		
//		PrintWriter pw = res.getWriter();
//		pw.println(json);
//	
//	}

}
