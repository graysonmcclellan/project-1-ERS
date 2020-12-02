package com.revature;

import com.revature.model.ReimbursementStatus;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		UserService us = new UserService();
//		
		//User u = new User("sb1", "pass", "Sarabeth", "McClellan", new Role(1,"Employee"));
////		
		//us.addUser(u);
		
		//WORKS!!!
		
//		User u = new User("gm", "pass", "Grayson", "McClellan", new Role(2, "Admin"));
//		
//		us.addUser(u);
		ReimbursementService rs = new ReimbursementService();
		//ReimbursementStatus newStatus = new ReimbursementStatus(2,"Approved");
		
		//System.out.println(rs.updateReimbursementStatus(1000, newStatus));
		
		//System.out.println(us.getAllEmployees());
		
		System.out.println(rs.getAllReimbursementsByUserId(12));
		
//		
//		ReimbursementType rt = new ReimbursementType(3, "Food");
//		
//
//		Reimbursement r = new Reimbursement(2, 50.00, "Dinner", "It was good",rt);
//
//		rs.addReimbursement(r);
		
		//LoginServlet login = new LoginServlet();
//		Scanner scan = new Scanner(System.in);
//		
//		String input1 = scan.nextLine();
//		String input2 = scan.nextLine();
//		
//		System.out.println(us.checkUsernameAndPassword(input1, input2));
//		
	//System.out.println(us.getUserByUsername("sb1"));
		
		//System.out.println(rs.getAllReimbursementsByUserIdAndStatusId(3,1));
		
		
	}
	
	
	public static void initialValues() {
		
		
		
		
		
	}
}
