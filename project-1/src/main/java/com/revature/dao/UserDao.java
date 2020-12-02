package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	

	
	public abstract boolean checkUsernameExists(String username);
	
	public abstract int checkUsernameAndPassword(String username, String password);
	
	public abstract boolean addUser(User user);
		
	public abstract User getUserById(int id);
	
	public abstract List<User> selectAllUsers();
	
	//public int getUserIdByFirstName(String firstName);
	
	//public int getUserIdByLastName()
	
	public abstract boolean checkUserIdExists(int userId);
	
	public abstract User getUserByUsername(String username);
	
	public abstract List<User> selectAllEmployees();
	
	

}
