package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileInfoServlet
 */
public class ProfileInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		response.getWriter().write("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Profile Info</title>\n"
				+ "<link rel=\"stylesheet\"\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\n"
				+ "	integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\"\n"
				+ "	crossorigin=\"anonymous\"> \n"
				+ "	\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<div class=\"jumbotron jumbotron-fluid\">\n"
				+ "		<div class=\"container\">\n"
				+ "			<h1 class=\"display-4\">Profile Information</h1>\n"
				+ "			<br/>\n"
				+ "			<br/>\n"
				+ "			<h4 class=\"lead\"><strong>First Name:</strong> "+session.getAttribute("firstName")+" </h4>\n"
				+ "			<br/>\n"
				+ "			<h4 class=\"lead\"><strong>Last Name:</strong> "+session.getAttribute("lastName")+ " </h4>\n"
				+ "			<br/>\n"
				+ "			<h4 class=\"lead\"><strong>Username:</strong> "+session.getAttribute("username")+"</h4>\n"
				+ "			<br/>\n"
				+ "			<h4 class=\"lead\"><strong>Password:</strong> "+session.getAttribute("password")+"</h4>\n"
				+ "			\n"
				+ "		</div>\n"
				+ "	</div> \n"
				+ "\n"
				+ "	\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>");
	
		response.setContentType("text/html");
		response.getWriter().write("	 	 <input type=\"button\" onclick=\"location.href='profile';\" class=\"btn btn-secondary btn-lg btn-block\" value=\"Return to Main Menu\" />\n"
				+ "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
