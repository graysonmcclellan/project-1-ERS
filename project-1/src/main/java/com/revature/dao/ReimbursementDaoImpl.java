package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{

	private Logger log = Logger.getLogger(ReimbursementDaoImpl.class);

	
	@Override
	public boolean createReimbursement(Reimbursement reimb) {
		// Account acc = new Account();
	//	Reimbursement reimburse = new Reimbursement();
				//AccountStatus as = new AccountStatus();
		
				// AccountType at = new AccountType();

				try (Connection conn = ConnectionUtil.getConnection()) {

					String query = "INSERT INTO reimbursement_info (owner_id, amount, title, decription, type_id , type, status_id, status)"
							+ " VALUES(?,?,?,?,?,?,?,?)";

					// will need to import prepared statement
					PreparedStatement ps = conn.prepareStatement(query);

					// sets parameters

					ps.setInt(1, reimb.getUserId()); // 2nd "?"
					// acc.setUserId(account.getUserId());

					ps.setDouble(2, reimb.getAmount()); // 3rd "?"
					// acc.setBalance(0.0);

					ps.setString(3, reimb.getTitle()); // 4th "?"
					// ps.setString(5, "Pending"); //4th "?"
					
					ps.setString(4,reimb.getDescription());

					ps.setInt(5, reimb.getType().getReimbTypeId());

					ps.setString(6, reimb.getType().getReimbType()); // 4th "?"
					
					ps.setInt(7, 1);

					ps.setString(8, "Pending"); // 4th "?"
					
					// acc.setAccountType(at);
					// sends info
					ps.executeUpdate();

					log.info("Reimbursement has been added to database and is pending approval.");
					return true;

				} catch (SQLException e) {
					e.printStackTrace();
					return false;

				}
	
	}


	@Override
	public List<Reimbursement> selectAllReimbursementsByUserId(int userId) {
		
			log.info("Retrieving all Reimbursements from this User");
			List<Reimbursement> reimbursements = new ArrayList<>();

			ReimbursementStatus rst = new ReimbursementStatus(0,null);
			ReimbursementType rt = new ReimbursementType(0,null);
			Reimbursement reimb = new Reimbursement(0,null,0.0,null,rt,rst);

			try (Connection conn = ConnectionUtil.getConnection()) {

				String sql = "SELECT * FROM reimbursement_info WHERE owner_id=" + userId;

				PreparedStatement ps = conn.prepareStatement(sql);

				// will need to import Result Set
				ResultSet rs = ps.executeQuery();

				// .next() says is there a next record? AND also goes to it
				while (rs.next()) {

					reimb.setReimbursementId(rs.getInt(1));
					
					reimb.setUserId(rs.getInt(2));
					
					reimb.setAmount(rs.getDouble(3));
					
					reimb.setTitle(rs.getString(4));
					
					reimb.setDescription(rs.getString(5));
					
					rt.setReimbTypeId(rs.getInt(6));
					rt.setReimbType(rs.getString(7));
					
					rst.setReimbStatusId(rs.getInt(8));
					rst.setReimbStatus(rs.getString(9));
					
					reimb.setType(rt);
					reimb.setStatus(rst);

					
					reimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2),rs.getString(4), rs.getDouble(3),rs.getString(5),
							new ReimbursementType(rs.getInt(6),rs.getString(7)), new ReimbursementStatus(rs.getInt(8), rs.getString(9))));
					

					// System.out.println(acc);

				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
			return reimbursements;
		}


	@Override
	public List<Reimbursement> selectAllReimbursementsByStatusId(int statusId) {

		log.info("Retrieving all Reimbursements from this Status Id");
		List<Reimbursement> reimbursements = new ArrayList<>();

		ReimbursementStatus rst = new ReimbursementStatus(0,null);
		ReimbursementType rt = new ReimbursementType(0,null);
		Reimbursement reimb = new Reimbursement(0,null,0.0,null,rt,rst);

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM reimbursement_info WHERE status_id=" + statusId;

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {

				reimb.setReimbursementId(rs.getInt(1));
				
				reimb.setUserId(rs.getInt(2));
				
				reimb.setAmount(rs.getDouble(3));
				
				reimb.setTitle(rs.getString(4));
				
				reimb.setDescription(rs.getString(5));
				
				rt.setReimbTypeId(rs.getInt(6));
				rt.setReimbType(rs.getString(7));
				
				rst.setReimbStatusId(rs.getInt(8));
				rst.setReimbStatus(rs.getString(9));
				
				reimb.setType(rt);
				reimb.setStatus(rst);

				
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2),rs.getString(4), rs.getDouble(3),rs.getString(5),
						new ReimbursementType(rs.getInt(6),rs.getString(7)), new ReimbursementStatus(rs.getInt(8), rs.getString(9))));
				

				// System.out.println(acc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return reimbursements;
	}


	@Override
	public List<Reimbursement> selectAllReimbursementsByUserIdAndStatusId(int userId, int statusId) {
		log.info("Retrieving all Reimbursements from this UserId and Status Id");
		List<Reimbursement> reimbursements = new ArrayList<>();

		ReimbursementStatus rst = new ReimbursementStatus(0,null);
		ReimbursementType rt = new ReimbursementType(0,null);
		Reimbursement reimb = new Reimbursement(0,null,0.0,null,rt,rst);

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM reimbursement_info WHERE status_id=" + statusId + "AND owner_id = "+userId;

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {

				reimb.setReimbursementId(rs.getInt(1));
				
				reimb.setUserId(rs.getInt(2));
				
				reimb.setAmount(rs.getDouble(3));
				
				reimb.setTitle(rs.getString(4));
				
				reimb.setDescription(rs.getString(5));
				
				rt.setReimbTypeId(rs.getInt(6));
				rt.setReimbType(rs.getString(7));
				
				rst.setReimbStatusId(rs.getInt(8));
				rst.setReimbStatus(rs.getString(9));
				
				reimb.setType(rt);
				reimb.setStatus(rst);

				
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2),rs.getString(4), rs.getDouble(3),rs.getString(5),
						new ReimbursementType(rs.getInt(6),rs.getString(7)), new ReimbursementStatus(rs.getInt(8), rs.getString(9))));
				

				// System.out.println(acc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return reimbursements;
		
	}


	@Override
	public boolean changeReimbursementStatus(int reimbursementId, ReimbursementStatus newStatus) {
		int statusId = newStatus.getReimbStatusId();
		String status = newStatus.getReimbStatus();
		
		int id = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql1 = "Select * FROM reimbursement_info WHERE reimb_id="+reimbursementId;
			
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
			

			String sql = "UPDATE reimbursement_info SET status_id = "+statusId +",status = '"+status+"' WHERE reimb_id =" + reimbursementId;

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			//ResultSet rs = ps.executeQuery();
			ps.executeUpdate();
			log.info("Reimbursement Status has been updated");
			
			
			if(id!=0) {
				return true;

			}else {
				return false;
			}
			// .next() says is there a next record? AND also goes to it
			

		} catch (SQLException e) {
			e.printStackTrace();
			return false;


		}
		
	}


	@Override
	public List<Reimbursement> selectAllResolvedReimbursements() {
		log.info("Retrieving all Resolved REimbursements from this User");
		List<Reimbursement> reimbursements = new ArrayList<>();

		ReimbursementStatus rst = new ReimbursementStatus(0,null);
		ReimbursementType rt = new ReimbursementType(0,null);
		Reimbursement reimb = new Reimbursement(0,null,0.0,null,rt,rst);

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM reimbursement_info WHERE status_id = 2 OR status_id = 3";

			PreparedStatement ps = conn.prepareStatement(sql);

			// will need to import Result Set
			ResultSet rs = ps.executeQuery();

			// .next() says is there a next record? AND also goes to it
			while (rs.next()) {

				reimb.setReimbursementId(rs.getInt(1));
				
				reimb.setUserId(rs.getInt(2));
				
				reimb.setAmount(rs.getDouble(3));
				
				reimb.setTitle(rs.getString(4));
				
				reimb.setDescription(rs.getString(5));
				
				rt.setReimbTypeId(rs.getInt(6));
				rt.setReimbType(rs.getString(7));
				
				rst.setReimbStatusId(rs.getInt(8));
				rst.setReimbStatus(rs.getString(9));
				
				reimb.setType(rt);
				reimb.setStatus(rst);

				
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2),rs.getString(4), rs.getDouble(3),rs.getString(5),
						new ReimbursementType(rs.getInt(6),rs.getString(7)), new ReimbursementStatus(rs.getInt(8), rs.getString(9))));
				

				// System.out.println(acc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return reimbursements;
	}


	

	

}
