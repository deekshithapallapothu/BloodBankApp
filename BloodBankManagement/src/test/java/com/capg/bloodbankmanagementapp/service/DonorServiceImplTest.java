package com.capg.bloodbankmanagementapp.service;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capg.bloodbankmanagementapp.beans.Donor;
import com.capg.bloodbankmanagementapp.exception.InvalidIdException;

public class DonorServiceImplTest {
   public DonorService id ;
   @Before
   public void init() {
	   
	   id=new DonorServiceImpl();
	   
   }
	@Test
	public void testGetDonorDetailsByID() throws InvalidIdException {
		int inputId=101;
		Donor expectedOutput=new Donor(101,45,"8456798125","Arjun","Male","B+","Delhi");
		Donor actualOutput=id.getDonorDetailsByID(inputId);
	}

}
