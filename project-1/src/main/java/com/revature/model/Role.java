package com.revature.model;



public class Role {
	
	
	private int roleId;
	

	private String role;
	


	






	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", Role=" + role + "]";
	}



	
	

}
