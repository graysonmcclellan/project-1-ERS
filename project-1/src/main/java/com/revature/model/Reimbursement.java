package com.revature.model;





public class Reimbursement {

	private int reimbursementId;
	
	private int userId;
	
	private String title;
	
	private double amount;

	private String description;
	
	private ReimbursementType type;
	
	private ReimbursementStatus status;
	
	

	public Reimbursement(int userId, double amount,String title, String description, ReimbursementType type) {
		super();
		this.userId = userId;
		this.title = title;
		this.amount = amount;
		this.description = description;
		this.type = type;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public Reimbursement(int userId, String title, double amount, String description, ReimbursementType type,
			ReimbursementStatus status) {
		super();
		this.userId = userId;
		this.title = title;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.status = status;
	}



	public Reimbursement(int reimbursementId, int userId, String title, double amount, String description,
			ReimbursementType type, ReimbursementStatus status) {
		super();
		this.reimbursementId = reimbursementId;
		this.userId = userId;
		this.title = title;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId= " + reimbursementId + ", userId= " + userId + ", title= " + title
				+ ", amount= " + amount + ", description= " + description + ", type= " + type + ", status= " + status + "]\n";
	}

	
	
	
	
	
	
	
	
	
}


