package com.capg.bloodbankmanagementapp.sorting;

import java.util.Comparator;

import com.capg.bloodbankmanagementapp.beans.Donor;

public class DonorSortByBloodGroup implements Comparator<Donor> {

	public int compare(Donor o1, Donor o2) {
		return (o1.getDonorBloodType().compareTo(o2.getDonorBloodType()));
	}

}