package com.capg.bloodbankmanagementapp.sorting;

import java.util.Comparator;

import com.capg.bloodbankmanagementapp.beans.Donor;

public class DonorSortByLocation implements Comparator<Donor>{
	public int compare(Donor l1, Donor l2) {
		return (l1.getDonorAddress().compareTo(l2.getDonorAddress()));

	};

}