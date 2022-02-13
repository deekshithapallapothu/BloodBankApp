package com.capg.bloodbankmanagementapp.service;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capg.bloodbankmanagementapp.beans.Recepients;
import com.capg.bloodbankmanagementapp.exception.InvalidIdException;

public class RecepientServiceImplTest {
	public RecepientService id ;
	   @Before
	   public void init() {
		   
		   id=new RecepientServiceImpl();
	   }   
	@Test
	public void testGetRecepientDetailsByID() throws InvalidIdException {
		int inputId=1001;
		Recepients expectedOutput=new Recepients(1001,25,"8445198125","Anu","Male","AB-","Banglore");
		Recepients actualOutput=id.getRecepientDetailsByID(inputId);
	}
}

