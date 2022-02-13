package com.capg.bloodbankmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.capg.bloodbankmanagementapp.beans.Login;
import com.capg.bloodbankmanagementapp.util.DBConnection;

public class LoginDAOImpl implements LoginDAO{
	
	public boolean vaidateEmail(String email,String pass){
		boolean result=false;
		
		
		List<String> username=new ArrayList<String>();
		List<String> password=new ArrayList<String>();
		
		
		username.add("deekshitha@gmail.com");
		username.add("tejaswini@gmail.com");
		username.add("tejaswi@gmail.com");
		username.add("srikanth@gmail.com");
		
	    
		password.add("11111");
		password.add("22222");
		password.add("33333");
		password.add("44444");
		
		
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		if(email.matches(regex)) {
			if(username.contains(email) && password.contains(pass)) {
				if(username.indexOf(email)==password.indexOf(pass)) {
					System.out.println("\n------------------------- Welcome...You can proceed!!!-------------------------");
					result=true;
				}
			}
			else {
				System.out.println("enter the correct email and password");
				result=false;
			}
		}
		else {
			System.out.println("Incorrect mail id !!!Please enter a valid e-mail id and Try again");
			result=false;
		}
		return result;
		
	}

	
}