package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

/**
 * Servlet implementation class ViewAllPendingServlet
 */
public class ViewAllPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllPendingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		ReimbursementService rs = new ReimbursementService();

		List<Reimbursement> reimbs = rs.getAllReimbursementsByStatusId(1);
		response.setContentType("text/html");
		response.getWriter().write("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Welcome to Login Page</title>\n"
				+ " <link rel=\"stylesheet\"\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n"
				+ "	integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\n"
				+ "	crossorigin=\"anonymous\"> \n"
				+ "\n"
				+ "<!-- Link to style sheet -->\n"
				+ "<link rel = \"stylesheet\" href = \"styles/myStyles.css\"/>\n"
				+ "\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ " <div class=\"jumbotron jumbotron-fluid\">\n"
				+ "		<div class=\"container\">\n"
				+ "			<h1 class=\"display-4\">Viewing All Pending Reinbursements</h1>\n"
				+ "			<p class=\"lead\">Showing all PENDING reimbursements:</p>\n"
				+ "		</div>\n"
				+ "	</div> \n"
				+ "\n"
				+ "	");



		response.setContentType("application/json");
		
		for(Reimbursement r: reimbs) {
			response.getWriter().write(r.toString());
			response.setContentType("text/html");
			response.getWriter().write("<br/><br/>");
			response.setContentType("application/json");
		}
		//response.getWriter().write(resolvedReimbs.toString());
		response.setContentType("text/html");
		response.getWriter().write("	 	 <input type=\"button\" onclick=\"location.href='admin';\" class=\"btn btn-secondary btn-lg btn-block\" value=\"Return to Main Menu\" />\n"
				+ "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
