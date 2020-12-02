package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;

public class ReimbursementService {
	
	ReimbursementDao repository = null;

	
	
	public ReimbursementService() {
		repository = new ReimbursementDaoImpl();
	}
	

	public boolean addReimbursement(Reimbursement reimb) {
		return repository.createReimbursement(reimb);
	}

	public List<Reimbursement> getAllReimbursementsByUserId(int userId){
		return repository.selectAllReimbursementsByUserId(userId);
	}
	
	
	public List<Reimbursement> getAllReimbursementsByStatusId(int statusId){
		return repository.selectAllReimbursementsByStatusId(statusId);
	}
	
	public List<Reimbursement> getAllReimbursementsByUserIdAndStatusId(int userId, int statusId){
		return repository.selectAllReimbursementsByUserIdAndStatusId(userId, statusId);
	}
	
	public boolean updateReimbursementStatus(int reimbursementId,ReimbursementStatus newStatus) {
		return repository.changeReimbursementStatus(reimbursementId, newStatus);
	}
	
	public List<Reimbursement> getAllResolvedReimbursements(){
		return repository.selectAllResolvedReimbursements();
	}
}

