package com.capg.bloodbankmanagementapp.sorting;

import java.util.Comparator;

import com.capg.bloodbankmanagementapp.beans.Recepients;

public class RecepientSortByLocation implements Comparator<Recepients>{
	public int compare(Recepients l3, Recepients l4) {
		return (l3.getRecepientAddress().compareTo(l4.getRecepientAddress()));

	};

}