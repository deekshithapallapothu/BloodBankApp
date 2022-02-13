package com.capg.bloodbankmanagementapp.beans;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class Donor {
	   
 
   private int donorId;
    
   private int donorAge;
 
   private String donorPhoneNumber;

   private String donorName;
  
   private String donorGender;
   
   private String donorBloodType;
  
   private String donorAddress;
  
   public Donor() {
	super();
	// TODO Auto-generated constructor stub
   }
public Donor(int donorId, int donorAge, String donorPhoneNumber, String donorName, String donorGender,
		String donorBloodType, String donorAddress) {
	super();
	this.donorId = donorId;
	this.donorAge = donorAge;
	this.donorPhoneNumber = donorPhoneNumber;
	this.donorName = donorName;
	this.donorGender = donorGender;
	this.donorBloodType = donorBloodType;
	this.donorAddress = donorAddress;
}
public int getDonorId() {
	return donorId;
}
public void setDonorId(int donorId) {
	this.donorId = donorId;
}
public int getDonorAge() {
	return donorAge;
}
public void setDonorAge(int donorAge) {
	this.donorAge = donorAge;
}
public String getDonorPhoneNumber() {
	return donorPhoneNumber;
}
public void setDonorPhoneNumber(String donorPhoneNumber) {
	this.donorPhoneNumber = donorPhoneNumber;
}
public String getDonorName() {
	return donorName;
}
public void setDonorName(String donorName) {
	this.donorName = donorName;
}
public String getDonorGender() {
	return donorGender;
}
public void setDonorGender(String donorGender) {
	this.donorGender = donorGender;
}
public String getDonorBloodType() {
	return donorBloodType;
}
public void setDonorBloodType(String donorBloodType) {
	this.donorBloodType = donorBloodType;
}
public String getDonorAddress() {
	return donorAddress;
}
public void setDonorAddress(String donorAddress) {
	this.donorAddress = donorAddress;
}
@Override
public String toString() {
	return "Donor [donorId=" + donorId + ", donorAge=" + donorAge + ", donorPhoneNumber=" + donorPhoneNumber
			+ ", donorName=" + donorName + ", donorGender=" + donorGender + ", donorBloodType=" + donorBloodType
			+ ", donorAddress=" + donorAddress + "]";
}
public static Donor getDonorDetails(String donorBloodType2) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((donorAddress == null) ? 0 : donorAddress.hashCode());
	result = prime * result + donorAge;
	result = prime * result + ((donorBloodType == null) ? 0 : donorBloodType.hashCode());
	result = prime * result + ((donorGender == null) ? 0 : donorGender.hashCode());
	result = prime * result + donorId;
	result = prime * result + ((donorName == null) ? 0 : donorName.hashCode());
	result = prime * result + ((donorPhoneNumber == null) ? 0 : donorPhoneNumber.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Donor other = (Donor) obj;
	if (donorAddress == null) {
		if (other.donorAddress != null)
			return false;
	} else if (!donorAddress.equals(other.donorAddress))
		return false;
	if (donorAge != other.donorAge)
		return false;
	if (donorBloodType == null) {
		if (other.donorBloodType != null)
			return false;
	} else if (!donorBloodType.equals(other.donorBloodType))
		return false;
	if (donorGender == null) {
		if (other.donorGender != null)
			return false;
	} else if (!donorGender.equals(other.donorGender))
		return false;
	if (donorId != other.donorId)
		return false;
	if (donorName == null) {
		if (other.donorName != null)
			return false;
	} else if (!donorName.equals(other.donorName))
		return false;
	if (donorPhoneNumber == null) {
		if (other.donorPhoneNumber != null)
			return false;
	} else if (!donorPhoneNumber.equals(other.donorPhoneNumber))
		return false;
	return true;
}

    
}