package com.capg.bloodbankmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.bloodbankmanagementapp.beans.Donor;
import com.capg.bloodbankmanagementapp.exception.InvalidBloodTypeException;
import com.capg.bloodbankmanagementapp.exception.InvalidIdException;
import com.capg.bloodbankmanagementapp.util.DBConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DonorDAOImpl implements DonorDAO {
	
	Connection con = DBConnection.con;
	PreparedStatement ps; // these are the statements which consist precompiled SQL quries
	//DonorDAO donorDAO=new DonorDAOImpl();
	public boolean insertDonarDAO(Donor donor){
		
		String sqlQuery = "insert into bloodbankmanagement.donor values(?,?,?,?,?,?,?)";
		
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, donor.getDonorId());
			ps.setInt(2, donor.getDonorAge());
			ps.setString(3, donor.getDonorPhoneNumber());
			ps.setString(4, donor.getDonorName());
			ps.setString(5, donor.getDonorGender());
			ps.setString(6, donor.getDonorBloodType());
			ps.setString(7, donor.getDonorAddress());
			
			
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

	
	public List<Donor> getDonorDetailsList() {
		String sqlQuery = "select * from bloodbankmanagement.donor";
        List<Donor> donorsList = new ArrayList<Donor>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);			
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);
			    donorsList.add(obj);				
				
			}
			return donorsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getDonor by age range "+e);
		}
		return null;
	}
	//end insertion
	
	public Donor getDonorDetails(String DonorBloodType) {
		String sqlQuery = "select * from bloodbankmanagement.donor where donorBloodType = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, DonorBloodType);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);			
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);
	            return obj;
			
			}
		} catch (Exception e) {
			
			System.out.println("Exception in getDonor by DonorId "+e);
		}

		return null;
	}
	 public List<Donor> sortingBasedOnDonorId(int iD) throws InvalidIdException
	 {
		String sqlQuery = "select * from bloodbankmanagement.donor where donorId=?";
		List<Donor> donorsList = new ArrayList<Donor>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, iD);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);			
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);
			donorsList.add(obj);
				
				
			}
			return donorsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getDonor by donor ID "+e);
		}
		return null;
	}
	public Donor getDonorDetailsByID(int donorId) throws InvalidIdException {
		String sqlQuery = "select * from bloodbankmanagement.donor where donorId = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, donorId);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);			
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);				
				return obj;
			}
		} 
		catch (Exception e) {
			
			System.out.println("Exception in getAccount by accountNumber "+e);
		}
		
		
		return null;
	}
	public List<Donor> getDonorDetails(int Range1, int Range2) {
		
		String sqlQuery = "select * from bloodbankmanagement.donor where donorAge>=? and donorAge<=?";
		List<Donor> donorsList = new ArrayList<Donor>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, Range1);
			ps.setInt(2, Range2);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);			
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);				
				donorsList.add(obj);
				
			}
			return donorsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getDonor by age range "+e);
		}
		return null;
	}
	
	//insert
	public List<Donor> sortingBasedOnBloodGroup(String bloodGroup) throws InvalidBloodTypeException
	{ 
		String sqlQuery = "select * from bloodbankmanagement.donor where donorBloodType=?";
		List<Donor> donorsList = new ArrayList<Donor>();
		
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, bloodGroup);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);			
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);
			donorsList.add(obj);
				
				
			}
			return donorsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getDonor by age range "+e);
		}
		return null;
	}
	//insertion ends
	
	
	public boolean modifyDonorDetails(String newdonorBloodType, int donorID)
			throws InvalidBloodTypeException, Exception {
		try {
			String sqlQuery = "update bloodbankmanagement.donor set donorBloodType = ? where donorId = ?";
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, newdonorBloodType);
			ps.setInt(2, donorID);
			
			int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
			if(i>0) return true;
			return false;
			
		} catch (Exception e) {
			System.out.println("Exception in bloodtype modification "+e);
		}
		
		return false;
	}
	public boolean insertDonorDAO(Donor donor) throws InvalidBloodTypeException {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Donor> sortingBasedOnLocation(String location) {
		String sqlQuery = "select * from bloodbankmanagement.donor where donorAddress=?";
		List<Donor> donorsList = new ArrayList<Donor>();
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int donorId1 = rs.getInt(1);
				int donorAge=rs.getInt(2);
				String donorPhoneNumber = rs.getString(3);
				String donorname = rs.getString(4);
				String donorGender = rs.getString(5);
				String donorBloodType = rs.getString(6);
				String donorAddress = rs.getString(7);
				//Donor obj = new Donor(donorId1,donogAge, donorname,donorPhoneNumber,donorBloodType,donorGender,donorAddress);				
				Donor obj=new Donor(donorId1, donorAge, donorPhoneNumber, donorname, donorGender, donorBloodType, donorAddress);
			donorsList.add(obj);
				
				
			}
			return donorsList;
			
		} catch (SQLException e) {
			System.out.println("Exception in getDonor by age range "+e);
		}
		return null;
	}
}