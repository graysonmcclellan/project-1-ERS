package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	//instantiate your logger
	private static Logger log = Logger. getLogger(ConnectionUtil.class);
	private static Connection conn;


	public static Connection getConnection(){
				
		
		//create connection strings
		String url = "jdbc:postgresql://revaturedatabase.camwstaxixz1.us-east-2.rds.amazonaws.com/project1";
		String username = "datachan";
		String password = "p4ssw0rd";
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			log.warn("Cannot load driver");
			e.printStackTrace();
		}
		
			try {
				
				conn = DriverManager.getConnection(url, username, password);
				
			}catch(SQLException e) {
				log.warn("Unable to obtain connection to database.", e);
			}
		
		
		return conn;
		
	
}
		

	
	

}
