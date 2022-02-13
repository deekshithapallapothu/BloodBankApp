package com.capg.bloodbankmanagementapp.dao;
import com.capg.bloodbankmanagementapp.beans.Login;
public interface LoginDAO {
	public boolean vaidateEmail(String email,String pass);
}
