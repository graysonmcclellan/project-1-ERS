package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ReimbursementStatus;
import com.revature.service.ReimbursementService;

/**
 * Servlet implementation class DenyReimbursement
 */
public class DenyReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("DenyReimbursement.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		int reimbId =Integer.parseInt( request.getParameter("reimbId"));
		
		ReimbursementService rs = new ReimbursementService();
		
		ReimbursementStatus rst = new ReimbursementStatus(3, "Denied");
		
		System.out.println("in reimbursement denial servlet doPost");
		if(rs.updateReimbursementStatus(reimbId, rst)==true) {
			System.out.println("in reimbursement denied and TRUE");
			request.getRequestDispatcher("SuccessDeniedReimbursement.html").forward(request, response);

		}
		else {
			request.getRequestDispatcher("UnsuccessfulDeniedReimbursement.html").forward(request, response);

		}
		
	}

}
