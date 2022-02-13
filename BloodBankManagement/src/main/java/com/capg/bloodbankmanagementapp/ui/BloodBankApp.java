package com.capg.bloodbankmanagementapp.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.capg.bloodbankmanagementapp.beans.Login;
import com.capg.bloodbankmanagementapp.beans.Donor;
import com.capg.bloodbankmanagementapp.beans.Recepients;

import com.capg.bloodbankmanagementapp.dao.DonorDAO;
import com.capg.bloodbankmanagementapp.dao.DonorDAOImpl;
import com.capg.bloodbankmanagementapp.dao.LoginDAO;
import com.capg.bloodbankmanagementapp.dao.LoginDAOImpl;
import com.capg.bloodbankmanagementapp.dao.RecepientDAO;
import com.capg.bloodbankmanagementapp.dao.RecepientDAOImpl;

import com.capg.bloodbankmanagementapp.exception.InvalidBloodTypeException;
import com.capg.bloodbankmanagementapp.exception.InvalidIdException;

import com.capg.bloodbankmanagementapp.service.DonorService;
import com.capg.bloodbankmanagementapp.service.DonorServiceImpl;
import com.capg.bloodbankmanagementapp.service.RecepientService;
import com.capg.bloodbankmanagementapp.service.RecepientServiceImpl;

import com.capg.bloodbankmanagementapp.sorting.DonorSortById;
import com.capg.bloodbankmanagementapp.sorting.DonorSortByLocation;
import com.capg.bloodbankmanagementapp.sorting.RecepientSortById;
import com.capg.bloodbankmanagementapp.sorting.RecepientSortByLocation;
import com.capg.bloodbankmanagementapp.sorting.DonorSortByBloodGroup;
import com.capg.bloodbankmanagementapp.sorting.RecepientSortByBloodGroup;

public class BloodBankApp {

	Scanner sc=new Scanner(System.in);
	Scanner scStr=new Scanner(System.in);
	DonorService donorServiceApp = new DonorServiceImpl();
	RecepientService recepientServiceApp = new RecepientServiceImpl();
	static BloodBankApp app=new BloodBankApp();
	LoginDAO login=new LoginDAOImpl();
	
	public static void main(String[] args) throws Exception {
	    while(true) {
	    	app.login();
	    	}
		}
		public void login() throws InvalidBloodTypeException, Exception {
			// TODO Auto-generated method stub
			System.out.println("\n\n\n ========= Blood Bank Application =========\n");
			System.out.println("Enter your Email Id");
			String email=scStr.nextLine();
			System.out.println("Enter your Password");
			String password=scStr.nextLine();
			if(email.equals("admin@gmail.com")&&(password.equals("admin"))) {
				System.out.println("You are good to go");
				try {
				app.callAdminChoice();	
				}
				catch (InvalidBloodTypeException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
			else if(login.vaidateEmail(email,password)) {
			   try {
				app.callUserChoice();
			} catch (InvalidBloodTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			}
		}
		
    public  void callUserChoice() throws InvalidBloodTypeException, Exception {
			
		
			while(true)
			{   
				System.out.println("\n");
				System.out.println("Choices For Donors");
				System.out.println("1. Insert Donor Details ");
				System.out.println("2. Modify donor details");
				System.out.println("\nChoices For Recepients");
				System.out.println("3. Insert Recepient Details");
				System.out.println("4. Search Blood Type form DonorTable");
				System.out.println("5. Sorting on DonorTable based on age");
				System.out.println("6. Modify recepient details");
				System.out.println("7. Get all donor details");
				System.out.println("8. Sorting on DonorTable based on Bloodgroup");
				System.out.println("9. Sorting on DonorTable based on Location");
				System.out.println("0. Logout");
				
				
				System.out.println("\nEnter ur choice ");
				int choice = app.sc.nextInt();
				System.out.println("\n");
				switch (choice) {
				case 1:app.insertDonor();
				       break;
				case 2:app.modifyDonorDetails();
			            break;
				case 3:app.insertRecepient();
			           break;
			    case 4:app.getRecepientSearch();
			           break;
			    case 5:app.getDonorBasedOnAge();
			           break;
			    case 6:app.modifyRecepientDetails();
			           break;
			    case 7:app.getAllDonorDetails();
                        break;
                case 8:app.sortingBasedOnBloodGroup();
			            break;
			    case 9:app.sortingDonorBasedOnLocation();
	                    break;
			     
				case 0:System.out.println("Logout sucess!!");
					    System.exit(0);
				        break;
				}
			}
				}
		
	   public void callAdminChoice() throws InvalidBloodTypeException, Exception {
		while(true)
		{
			System.out.println("\n----ADMIN ACCESS GRANTED----\n");
			System.out.println("Choices For Donors");
			System.out.println("1. Insert Donor Details ");
			System.out.println("2. Get donors by Blood Type");
			System.out.println("3. Get donor by Donor Id");
			System.out.println("4. Get donors Based on Age");
			System.out.println("5. Modify donor details");
			System.out.println("6. Filter a particular donor based on ID in a particular age group");
			System.out.println("7. Get all donor details");
			System.out.println("8. Sorting Donor based on Blood Groups");
			System.out.println("17. Sorting Donor Based on Location");
			System.out.println("\nChoices For Recepients");
			System.out.println("9. Insert Recepient Details");
			System.out.println("10. Search Blood Type form DonorTable");
			System.out.println("11. Get Recepient by Recepient Id");
			System.out.println("12. Get Recepient Based on Age");
			System.out.println("13. Modify Recepient details");
			System.out.println("14. Filter a particular recepeint based on ID in a particular age group");
			System.out.println("15. Get all Recepient details");
			System.out.println("16. Sorting Recepient based on Blood Groups");
			System.out.println("18. Sorting Recepient Based on Location");
			System.out.println("0. Logout");
			
			
			System.out.println("\nEnter ur choice ");
			int choice = app.sc.nextInt();
			System.out.println("\n");
			switch (choice) {
			case 1:app.insertDonor();
			       break;
			case 2:app.getDonorDetails();
			       break;
			case 3:app.getDonorDetailsbyId();
		           break;
			case 4:app.getDonorBasedOnAge();
			       break;
			case 5:app.modifyDonorDetails();
			       break;
			case 6:app.getDonorBasedOnSorting();
			      break;
			case 7:app.getAllDonorDetails();
			       break;
			case 8:app.sortingBasedOnBloodGroup();
		       break;
			
			case 9:app.insertRecepient();
		           break;
		    case 10:app.getRecepientSearch();
		           break;
		    case 11:app.getRecepientDetailsbyId();
	               break;
		    case 12:app.getRecepientBasedOnAge();
		           break;
		    case 13:app.modifyRecepientDetails();
		           break;
		    case 14:app.getRecepientBasedOnSorting();
		            break;
		    case 15:app.getAllRecepientDetailsList();
                    break;
		      
		    case 16:app.sortingBasedOnRecepientBloodGroup();
		            break;
		    case 17:app.sortingDonorBasedOnLocation();
                    break;
		    case 18:app.sortingRecepientBasedOnLocation();
                    break;
		     
			case 0 :System.out.println("Logout sucess!!");
				    System.exit(0);
			        break;
			
			}
		}
	}

	public Donor insertDonor()
	{
		
		DonorDAO donorDAO=new DonorDAOImpl();
		try {
            System.out.println("Enter new donor ID==like ---->101/102...");
            int id=sc.nextInt();
            System.out.println("Enter donor age");
            int age=sc.nextInt();
            System.out.println("Enter PhoneNumber");
            String pn=scStr.nextLine();
            System.out.println("Enter donor name");
            String name=scStr.nextLine();
            System.out.println("Enter donor gender");
            String gender=scStr.nextLine();
            System.out.println("Enter donor blood group==like ---->A+/A-/AB+...CAPITALS ONLY");
            String bgroup=scStr.nextLine();
            System.out.println("Enter donor address");
            String address=scStr.nextLine();
            
			Donor d = new Donor(id,age,pn,name,gender,bgroup,address);
			
			boolean status = donorDAO.insertDonarDAO(d);
			System.out.println(status);
			System.out.println("Donor Details have been insert into table sucessfully ");
			return d;	
             
		} 
		catch (Exception e) {
			System.out.println("Details have not been inserted "+e);
		}
		return null;

	}
	public Donor getDonorDetails() throws InvalidBloodTypeException {
		System.out.println("Enter  blood type");
		String bloodType=scStr.nextLine();
		
		Donor d = donorServiceApp.getDonorDetails(bloodType);
		System.out.println(d);
		return d;

	}
	public void getDonorDetailsbyId() throws InvalidBloodTypeException, Exception{
		System.out.println("enter id");
		int id=sc.nextInt();
		Donor d = donorServiceApp.getDonorDetailsByID(id);
		System.out.println("Your search was found sucessfully!!");
		System.out.println(d);

	}
	
	public void getDonorBasedOnAge()
	{
		System.out.println("enter range1");
		int range1=sc.nextInt();
		System.out.println("enter range2");
		int range2=sc.nextInt();
		List<Donor> donors = donorServiceApp.getDonorDetailsRange(range1,range2);
		System.out.println("Below are the donors  between the given range....");
		for (Donor donor : donors) {
			
			System.out.println(donor);
			
		}
    
	}
	public void modifyDonorDetails() throws InvalidBloodTypeException, Exception
	{  
		System.out.println("Re-Login again for confirmation");
		System.out.println("Enter email");
		String email=scStr.nextLine();
		System.out.println("Enter password");
		String password=scStr.nextLine();
		
		if(email.equals("admin@gmail.com")&&(password.equals("admin"))) {
			
			System.out.println("Enter Blood Type you need to modify--->like  A+/A-/O+...!!");
			String bloodType=scStr.nextLine();  
			System.out.println("enter ID");
			int id=sc.nextInt();
			boolean status = donorServiceApp.modifyDonorDetails(bloodType,id);
			System.out.println(status);
			
		}
		
		else if(login.vaidateEmail(email,password)) {
			System.out.println("Enter Blood Type you need to modify!!");
			String bloodType=scStr.nextLine();  
			System.out.println("enter ID");
			int id=sc.nextInt();
			boolean status = donorServiceApp.modifyDonorDetails(bloodType,id);
			System.out.println(status);}
	     else {
				System.out.println("Something went wrong please try again");
		}

		
		
	}
	public void getDonorBasedOnSorting()
	{
		List<Donor> donor = donorServiceApp.getDonorDetailsRange(10,35);
        Collections.sort(donor,new DonorSortById());
        for (Donor donor1 : donor) {
        System.out.println(donor1);
        System.out.println();
        }
	}
	
	//
	public void getAllDonorDetails()
	{
		List<Donor> donors = donorServiceApp.getDonorDetailsList();
		for (Donor donor : donors) {
			System.out.println(donor);
		}
	}
	
	public void sortingBasedOnBloodGroup()
	{
		List<Donor> donor = donorServiceApp.getDonorDetailsList();
        Collections.sort(donor,new DonorSortByBloodGroup());
        for (Donor donors : donor) {
        	System.out.println(donors);
            System.out.println();
        }
	}
	
	public Recepients insertRecepient()
	{
		
		RecepientDAO recepientDAO=new RecepientDAOImpl();
		try {

			System.out.println("Enter new recepient ID==like ---->1001/1002...");
            int id=sc.nextInt();
            System.out.println("Enter recepient age");
            int age=sc.nextInt();
            System.out.println("Enter recepient PhoneNumber");
            String pn=scStr.nextLine();
            System.out.println("Enter recepient name");
            String name=scStr.nextLine();
            System.out.println("Enter recepient gender");
            String gender=scStr.nextLine();
            System.out.println("Enter recepient blood group==like ---->A+/A-/AB+...CAPITALS ONLY\"");
            String bgroup=scStr.nextLine();
            System.out.println("Enter recepient address");
            String address=scStr.nextLine();
			
            Recepients r = new Recepients(id,age,pn,name,gender,bgroup,address);
			
			boolean status = recepientDAO.insertRecepientDAO(r);
			System.out.println(status);
			System.out.println("Recepient Details have been insert into table sucessfully ");
			return r;	

		} 
		catch (Exception e) {
			System.out.println("Details have not been inserted "+e);
		}
		return null;
	}
	

	public boolean getRecepientSearch() throws InvalidBloodTypeException 
	{
		System.out.println("Enter Blood Type you need!!");
		String bloodType=scStr.nextLine();
		boolean r= recepientServiceApp.SearchBloodType(bloodType);
		if(r==true) {
			System.out.println("Blood avaliable");
		  if(bloodType=="A+")
			  System.out.println("Cost is 15000");
		  else  if(bloodType=="A-")
			  System.out.println("Cost is 11000");
		  else  if(bloodType=="AB+")
			  System.out.println("Cost is 25000");
		  else  if(bloodType=="AB-")
			  System.out.println("Cost is 25000");
		  else  if(bloodType=="B+")
			  System.out.println("Cost is 15000");
		  else  if(bloodType=="B-")
			  System.out.println("Cost is 17000");
		  else  if(bloodType=="O+")
			  System.out.println("Cost is 15000");
		  else  
			  System.out.println("Cost is 25000");
		}
		else System.out.println("Blood Not available");
		return true;
		
	}
	public void getRecepientDetailsbyId() throws InvalidBloodTypeException, Exception
	{
		System.out.println("Enter  recepient Id");
		int num=sc.nextInt();
		Recepients r = recepientServiceApp.getRecepientDetailsByID(num);
		System.out.println("Your search was found sucessfully!!");
		System.out.println(r);
		
	}
	
	public void getRecepientBasedOnAge() throws InvalidBloodTypeException, Exception
	{   
		System.out.println("Enter range1");
		int range1=sc.nextInt();
		System.out.println("Enter range2");
		int range2=sc.nextInt();
		List<Recepients> recepients = recepientServiceApp.getRecepientDetailsRange(range1, range2);
		System.out.println("Below are the recepients  between given range.....");
		for (Recepients recepient : recepients) {
			System.out.println(recepient);
		}
	
	}
	public void modifyRecepientDetails() throws InvalidBloodTypeException,Exception
	{
		System.out.println("Re-Login again for confirmation");
		System.out.println("Enter email");
		String email=scStr.nextLine();
		System.out.println("Enter password");
		String password=scStr.nextLine();
		
		if(email.equals("admin@gmail.com")&&(password.equals("admin"))) {
        System.out.println("Enter Blood Type you need to modify--->like  A+/A-/O+...!!");
		String bloodType=scStr.nextLine();  
		System.out.println("enter ID");
		int id=sc.nextInt();
		boolean status = recepientServiceApp.modifyRecepientDetails(bloodType, id);
		System.out.println(status);
		}
		
		else if(login.vaidateEmail(email,password)) {
			System.out.println("Enter Blood Type you need to modify!!");
			String bloodType=scStr.nextLine();  
			System.out.println("enter ID");
			int id=sc.nextInt();
			boolean status = recepientServiceApp.modifyRecepientDetails(bloodType, id);}
		else
			System.out.println("Something went wrong please try again");

		
	}
	public void getRecepientBasedOnSorting()
	{
		List<Recepients> recepient = recepientServiceApp.getRecepientDetailsRange(15,45);
        Collections.sort(recepient,new RecepientSortById());
        for (Recepients recepient1 : recepient) {
        	System.out.println(recepient1);
            System.out.println();
        }
    }		
	
	public void getAllRecepientDetailsList()
	{
		List<Recepients> recepients = recepientServiceApp.getRecepientDetailsList();
		for (Recepients recepient : recepients) {
			
			System.out.println(recepient);
			
		}
	}
	public void sortingBasedOnRecepientBloodGroup()
	{
		List<Recepients> recepient = recepientServiceApp.getRecepientDetailsList();
        Collections.sort(recepient,new RecepientSortByBloodGroup());
        for (Recepients recepients : recepient) {
        	System.out.println(recepients);
            System.out.println();
		}
	}
	public void sortingDonorBasedOnLocation()
	{
		List<Donor> donor = donorServiceApp.getDonorDetailsList();
        Collections.sort(donor,new DonorSortByLocation());
        for (Donor donors : donor) {
        System.out.println(donors);
        System.out.println();
        }
	}
	public void sortingRecepientBasedOnLocation() {
        List<Recepients> recepient = recepientServiceApp.getRecepientDetailsList();
        Collections.sort(recepient,new RecepientSortByLocation());
        for (Recepients recepients: recepient) {
        System.out.println(recepients);
        System.out.println();
        }
	}
   
}