package com.capg.bloodbankmanagementapp.sorting;

import java.util.Comparator;

import com.capg.bloodbankmanagementapp.beans.Recepients;

public class RecepientSortByBloodGroup implements Comparator<Recepients> {
	
	public int compare(Recepients p1, Recepients p2) {
		return (p1.getRecepientBloodType().compareTo(p2.getRecepientBloodType()));
	}

}
