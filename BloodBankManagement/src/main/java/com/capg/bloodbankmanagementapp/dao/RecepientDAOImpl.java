package com.capg.bloodbankmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.bloodbankmanagementapp.beans.Donor;
import com.capg.bloodbankmanagementapp.beans.Recepients;
import com.capg.bloodbankmanagementapp.exception.InvalidBloodTypeException;
import com.capg.bloodbankmanagementapp.exception.InvalidIdException;
import com.capg.bloodbankmanagementapp.util.DBConnection;


public class RecepientDAOImpl implements RecepientDAO {
   
	Connection con = DBConnection.con;
	PreparedStatement ps; // these are the statements which consist precompiled SQL quries
	DonorDAO donorDAO=new DonorDAOImpl();
	public boolean insertRecepientDAO(Recepients recepient){
		
		String sqlQuery = "insert into bloodbankmanagement.recepients values(?,?,?,?,?,?,?)";
		//String sqlQuery ="insert into bloodbankmanagement.donor values(101,45,"8456798125","Arjun","Male","A+","Delhi")";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, recepient.getRecepientId());
			ps.setInt(2, recepient.getRecepientAge());
			ps.setString(3, recepient.getRecepientPhoneNumber());
			ps.setString(4, recepient.getRecepientname());
			ps.setString(5, recepient.getRecepientGender());
			ps.setString(6, recepient.getRecepientBloodType());
			ps.setString(7, recepient.getRecepientAddress());
			
			
			int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
			if(i==1) return true;
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Eception while Data Insertion "+e);
		}
		
		return false;
	}
	
	public List<Recepients> getRecepientDetailsList() {
		String sqlQuery = "select * from bloodbankmanagement.recepients";
        List<Recepients> recepientsList = new ArrayList<Recepients>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int recepientId1 = rs.getInt(1);
				int recepientAge=rs.getInt(2);
				String recepientPhoneNumber = rs.getString(3);
				String recepientname = rs.getString(4);
				String recepientGender = rs.getString(5);
				String recepientBloodType = rs.getString(6);
				String recepientAddress = rs.getString(7);			
				Recepients obj=new Recepients(recepientId1, recepientAge, recepientPhoneNumber, recepientname, recepientGender, recepientBloodType, recepientAddress);
			    recepientsList.add(obj);				
				
			}
			return recepientsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getRecepient by age range "+e);
		}
		return null;
	}
	
	public boolean searchForBloodType(String BloodType) {
		 Donor blood=donorDAO.getDonorDetails(BloodType);
		 if(blood==null)
			 return false;
		return true;
	}


	public Recepients getRecepientDetailsByID(int recepientId) throws InvalidIdException {
		String sqlQuery = "select * from bloodbankmanagement.recepients where recepientsId = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, recepientId);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int recepientId1 = rs.getInt(1);
				int recepientAge=rs.getInt(2);
				String recepientPhoneNumber = rs.getString(3);
				String recepientname = rs.getString(4);
				String recepientGender = rs.getString(5);
				String recepientBloodType = rs.getString(6);
				String recepientAddress = rs.getString(7);			
				Recepients obj=new Recepients(recepientId1, recepientAge, recepientPhoneNumber, recepientname, recepientGender, recepientBloodType, recepientAddress);			
				return obj;
			
			}
		} catch (Exception e) {
			
			System.out.println("Exception in getRecepientById by recepientId "+e);
		}
		
		
		return null;
	}
	public List<Recepients> getRecepientDetails(int Range1, int Range2) {
		
		String sqlQuery = "select * from bloodbankmanagement.recepients where recepientsAge>=? and recepientsAge<=?";
		List<Recepients> recepientsList = new ArrayList<Recepients>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, Range1);
			ps.setInt(2, Range2);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int recepientId1 = rs.getInt(1);
				int recepientAge=rs.getInt(2);
				String recepientPhoneNumber = rs.getString(3);
				String recepientname = rs.getString(4);
				String recepientGender = rs.getString(5);
				String recepientBloodType = rs.getString(6);
				String recepientAddress = rs.getString(7);	
				Recepients obj=new Recepients(recepientId1, recepientAge, recepientPhoneNumber, recepientname, recepientGender, recepientBloodType, recepientAddress);			
				recepientsList.add(obj);
				
			}
			return recepientsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getRecepient by balance range "+e);
		}
		
		
		return null;
	}

		public List<Recepients> sortingBasedOnRecepientBloodGroup(String recepientBloodGroup) 
				throws InvalidBloodTypeException
		{ 
			String sqlQuery = "select * from bloodbankmanagement.recepients where recepientsBloodType=?";
			List<Recepients> recepientsList = new ArrayList<Recepients>();
			
			try {
				ps = con.prepareStatement(sqlQuery);
				ps.setString(1, recepientBloodGroup);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					int recepientId1 = rs.getInt(1);
					int recepientAge=rs.getInt(2);
					String recepientPhoneNumber = rs.getString(3);
					String recepientname = rs.getString(4);
					String recepientGender = rs.getString(5);
					String recepientBloodType = rs.getString(6);
					String recepientAddress = rs.getString(7);			
					Recepients obj=new Recepients(recepientId1, recepientAge, recepientPhoneNumber, recepientname, recepientGender, recepientBloodType, recepientAddress);
					recepientsList.add(obj);
					
					
				}
				return recepientsList;
				
			} catch (SQLException e) {
				System.out.println("Exception in getRecepient by age range "+e);
			}
			return null;
		}
	
	public boolean modifyRecepientDetails(String newrecepientBloodType, int recepientID)
			throws InvalidBloodTypeException, InvalidIdException {
		try {
			String sqlQuery = "update bloodbankmanagement.recepients set recepientsBloodType = ? where recepientsId = ?";
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, newrecepientBloodType);
			ps.setInt(2, recepientID);
			
			int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
			if(i>0) return true;
			return false;
			
		} catch (Exception e) {
			System.out.println("Exception in BloodType modification "+e);
		}
		
		return false;
	}

	public List<Recepients> sortingRBasedOnLocation(String location) {
		String sqlQuery = "select * from bloodbankmanagement.donor where donorAddress=?";
		List<Recepients> recepientList = new ArrayList<Recepients>();
		try {
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int recepientId1 = rs.getInt(1);
				int recepientAge=rs.getInt(2);
				String recepientPhoneNumber = rs.getString(3);
				String recepientname = rs.getString(4);
				String recepientGender = rs.getString(5);
				String recepientBloodType = rs.getString(6);
				String recepientAddress = rs.getString(7);
				//Donor obj = new Donor(donorId1,donogAge, donorname,donorPhoneNumber,donorBloodType,donorGender,donorAddress);				
				Recepients obj = new Recepients(recepientId1, recepientAge, recepientname, recepientPhoneNumber,
						recepientBloodType, recepientGender, recepientAddress);
			recepientList.add(obj);
				
				
			}
			return recepientList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getDonor by age range "+e);
		}
		return null;
	}

	}