package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;


//PROJECT 
public class UserDaoImpl implements UserDao {
	private Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public boolean checkUsernameExists(String username) {

		int id = 0;

		// get database connection
		try (Connection conn = ConnectionUtil.getConnection()) {

			// Create SQL Query that will execute in DBeaver
			String sql = "SELECT * FROM userinfo WHERE username = '" + username + "'";

			// create Statement
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			/*
			 * ResultSet starts at 1 position behind the starting point of our data ...So in
			 * order to access the value we invoke next() to start...
			 */

			while (rs.next()) {

				id = rs.getInt("user_id");
				log.info("Username has been found in database!!");

			}

		} catch (SQLException e) {

			log.warn("Unable to retrieve data from database!!", e);

		}
		if (id == 0) {
			log.info("User does not exist in database!!");
			return false;
		} else {
			log.info("Username exists within database!!");

			return true;
		}

	}

	@Override
	public int checkUsernameAndPassword(String username, String password) {
		int id = 0;
		String pass = "";

		// get database connection
		try (Connection conn = ConnectionUtil.getConnection()) {

			if(conn==null) {
				System.out.println("Heres the problem");
			}
			
			// Create SQL Query that will execute in DBeaver
			String sql = "SELECT * FROM user_info WHERE username = '" + username + "'";

			
			
			// create Statement
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			/*
			 * ResultSet starts at 1 position behind the starting point of our data ...So in
			 * order to access the value we invoke next() to start...
			 */

			while (rs.next()) {

				pass = rs.getString("password");
				if (password.equals(pass)) {
					// y System.out.println("password correct");
					id = rs.getInt("user_id");
					return id;

				} else
					return id;

			}

		} catch (SQLException e) {

			log.warn("Unable to retrieve employees from database!!", e);

		}

//		System.out.println(pass);
//		System.out.println(password);
//		System.out.println(id);

		return id;

	}

	@Override
	public boolean addUser(User user) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String query = "INSERT INTO user_info (username, password, first_name, last_name, role_id, role) "
					+ "VALUES(?,?,?,?,?,?)";

			// will need to import prepared statement
			PreparedStatement ps = conn.prepareStatement(query);
			// sets parameters

			ps.setString(1, user.getUsername()); // 2nd "?"

			ps.setString(2, user.getPassword()); // 3rd "?"

			ps.setString(3, user.getFirstName()); // 4th "?"

			ps.setString(4, user.getLastName()); // 4th "?"

			ps.setInt(5, user.getRole().getRoleId()); // 4th "?"

			ps.setString(6, user.getRole().getRole()); // 4th "?"

			ps.executeUpdate();

			log.info("User has been added to the database");
			// System.out.println("New User has been created...");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return false;

	}

	@Override // need to go back and edit
	public User getUserById(int userId) {
		User u = new User(null, null, null, null, null);
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_info WHERE user_id=" + userId;

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {
				// might be wrong w creating role at the end
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));

				u.setRole(new Role(rs.getInt(6), rs.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return u;
	}

	@Override
	public List<User> selectAllUsers() {
		log.info("Retrieving all users from database");
		List<User> users = new ArrayList<>(); // creates list of pokemon objects

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_info";

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {
				// might be wrong w creating role at the end

				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						new Role(rs.getInt(6), rs.getString(7))));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return users;
	}

	public User selectUserbyId(int userId) {
		log.info("Retrieving this user from the database..");
		User u = new User(0,null,null,null,null,null);
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_info WHERE user_id=" + userId;

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {
				// might be wrong w creating role at the end
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));
				u.setRole(new Role(rs.getInt(6), rs.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return u;

	}

	@Override
	public boolean checkUserIdExists(int userId) {
		log.info("Checking if user exists in database...");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_info WHERE user_id=" + userId;

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {
				// might be wrong w creating role at the end
				log.info("Found user within database...");

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
		return false;
		
	}

	@Override
	public User getUserByUsername(String username) {
		log.info("Retrieving this user from the database..");
		User u = new User(0,null,null,null,null,null);
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_info WHERE username = '" + username +"'";

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {
				// might be wrong w creating role at the end
				u.setUserId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));
				u.setRole(new Role(rs.getInt(6), rs.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return u;
		
	}

	@Override
	public List<User> selectAllEmployees() {
		log.info("Retrieving all employees from database");
	List<User> users = new ArrayList<>(); // creates list of pokemon objects

	try (Connection conn = ConnectionUtil.getConnection()) {

		String sql = "SELECT * FROM user_info WHERE role_id = 1";

		PreparedStatement ps = conn.prepareStatement(sql);

		// will need to import Result Set
		ResultSet rs = ps.executeQuery();

		// .next() says is there a next record? AND also goes to it
		while (rs.next()) {
			// might be wrong w creating role at the end

			users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					new Role(rs.getInt(6), rs.getString(7))));
		}

	} catch (SQLException e) {
		e.printStackTrace();

	}
	return users;

	}

	

	
	
	

}
