package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JSONServlet
 */
public class JsonProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //JSON is Javascript Object Notation, converts JavaObjects into JSON
	// Known as a Data Exchange format
	
    public JsonProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		//says if current session exists...
		if(session != null) {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\": \""+ session.getAttribute("username") +"\"}");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
