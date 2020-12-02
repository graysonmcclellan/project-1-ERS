package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

//project 1
public class UserService {

	UserDao repository = null;

	
	
	public UserService() {
		repository = new UserDaoImpl();
	}
	
	
	public boolean checkUsernameExists(String username) {
		return repository.checkUsernameExists(username);
	}
	
	public int checkUsernameAndPassword(String username, String password) {
		return repository.checkUsernameAndPassword(username, password);
	}

	public boolean addUser(User user) {
		return repository.addUser(user);
	}
	
	public User getUserById(int id) {
		return repository.getUserById(id);
	}
	
	public List<User> getAllUsers(){
		return repository.selectAllUsers();
	}
	
	public User getUserByUserId(int userId) {
		return repository.getUserById(userId);
	}
	
	public boolean checkUserIdExists(int userId) {
		return repository.checkUserIdExists(userId);
	}
	public User getUserByUsername(String username) {
		return repository.getUserByUsername(username);
	}
	
	public List<User> getAllEmployees(){
		return repository.selectAllEmployees();
	}

}
