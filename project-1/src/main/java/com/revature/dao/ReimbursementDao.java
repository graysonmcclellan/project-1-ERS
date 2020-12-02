package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;

public interface ReimbursementDao {
	
	
	public abstract boolean createReimbursement(Reimbursement reimb);
	
	public abstract List<Reimbursement> selectAllReimbursementsByUserId(int userId);

	public abstract List<Reimbursement> selectAllReimbursementsByStatusId(int statusId);
	
	public abstract List<Reimbursement> selectAllReimbursementsByUserIdAndStatusId(int userId,int statusId);

	public abstract boolean changeReimbursementStatus(int reimbursementId, ReimbursementStatus newStatus);

	
	public abstract List<Reimbursement> selectAllResolvedReimbursements();
}
