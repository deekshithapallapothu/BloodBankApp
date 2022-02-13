package com.capg.bloodbankmanagementapp.beans;


public class Login {
	private static String email;
	private static String password;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Login.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Login.password = password;
	}
	@Override
	public String toString() {
		return "DonorLogin [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}