package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

/**
 * Servlet implementation class NewReimbursementServlet
 */
public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public NewReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("NewReimbursement.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creates new session 
				HttpSession session = request.getSession();
				
				//get current user for user id
				UserService us = new UserService();

				User currUser = us.getUserByUsername((String)session.getAttribute("username"));
				
				int userId = currUser.getUserId();
				System.out.println(currUser.getUserId());
				//collect parameters
				String title = request.getParameter("title");
				double amount = Double.parseDouble(request.getParameter("amount"));
				String description = request.getParameter("description");
				int typeId = Integer.parseInt(request.getParameter("type"));
				
				ReimbursementService rs = new ReimbursementService();
				
				ReimbursementType rt = new ReimbursementType(0, null);
				
				if(typeId ==1) {
					rt.setReimbTypeId(1);
					rt.setReimbType("Lodging");
				}else if( typeId == 2) {
					rt.setReimbTypeId(2);
					rt.setReimbType("Travel");
				}else if(typeId == 3) {
					rt.setReimbTypeId(3);
					rt.setReimbType("Food");
				}else {
					rt.setReimbTypeId(4);
					rt.setReimbType("Other");
				}
				
				Reimbursement reimb = new Reimbursement(userId, title, amount, description,rt, new ReimbursementStatus(1,"Pending"));
				rs.addReimbursement(reimb);
				
			
				
				//redirects back to index
				response.sendRedirect("profile");
	}

}
