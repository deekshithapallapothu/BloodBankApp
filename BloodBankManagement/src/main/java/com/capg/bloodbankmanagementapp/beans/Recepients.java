package com.capg.bloodbankmanagementapp.beans;

public class Recepients {
	
   private int recepientId;
   private int recepientAge;
   private	String recepientPhoneNumber;
    
   private String recepientname;
   private String recepientGender;
  
   private String recepientBloodType;
   private String recepientAddress;
   public Recepients() {
	super();
	// TODO Auto-generated constructor stub
    }
public Recepients(int recepientId, int recepientAge, String recepientPhoneNumber, String recepientname,
		String recepientGender, String recepientBloodType, String recepientAddress) {
	super();
	this.recepientId = recepientId;
	this.recepientAge = recepientAge;
	this.recepientPhoneNumber = recepientPhoneNumber;
	this.recepientname = recepientname;
	this.recepientGender = recepientGender;
	this.recepientBloodType = recepientBloodType;
	this.recepientAddress = recepientAddress;
}
public int getRecepientId() {
	return recepientId;
}
public void setRecepientId(int recepientId) {
	this.recepientId = recepientId;
}
public int getRecepientAge() {
	return recepientAge;
}
public void setRecepientAge(int recepientAge) {
	this.recepientAge = recepientAge;
}
public String getRecepientPhoneNumber() {
	return recepientPhoneNumber;
}
public void setRecepientPhoneNumber(String recepientPhoneNumber) {
	this.recepientPhoneNumber = recepientPhoneNumber;
}
public String getRecepientname() {
	return recepientname;
}
public void setRecepientname(String recepientname) {
	this.recepientname = recepientname;
}
public String getRecepientGender() {
	return recepientGender;
}
public void setRecepientGender(String recepientGender) {
	this.recepientGender = recepientGender;
}
public String getRecepientBloodType() {
	return recepientBloodType;
}
public void setRecepientBloodType(String recepientBloodType) {
	this.recepientBloodType = recepientBloodType;
}
public String getRecepientAddress() {
	return recepientAddress;
}
public void setRecepientAddress(String recepientAddress) {
	this.recepientAddress = recepientAddress;
}
@Override
public String toString() {
	return "Recepients [recepientId=" + recepientId + ", recepientAge=" + recepientAge + ", recepientPhoneNumber="
			+ recepientPhoneNumber + ", recepientname=" + recepientname + ", recepientGender=" + recepientGender
			+ ", recepientBloodType=" + recepientBloodType + ", recepientAddress=" + recepientAddress + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((recepientAddress == null) ? 0 : recepientAddress.hashCode());
	result = prime * result + recepientAge;
	result = prime * result + ((recepientBloodType == null) ? 0 : recepientBloodType.hashCode());
	result = prime * result + ((recepientGender == null) ? 0 : recepientGender.hashCode());
	result = prime * result + recepientId;
	result = prime * result + ((recepientPhoneNumber == null) ? 0 : recepientPhoneNumber.hashCode());
	result = prime * result + ((recepientname == null) ? 0 : recepientname.hashCode());
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
	Recepients other = (Recepients) obj;
	if (recepientAddress == null) {
		if (other.recepientAddress != null)
			return false;
	} else if (!recepientAddress.equals(other.recepientAddress))
		return false;
	if (recepientAge != other.recepientAge)
		return false;
	if (recepientBloodType == null) {
		if (other.recepientBloodType != null)
			return false;
	} else if (!recepientBloodType.equals(other.recepientBloodType))
		return false;
	if (recepientGender == null) {
		if (other.recepientGender != null)
			return false;
	} else if (!recepientGender.equals(other.recepientGender))
		return false;
	if (recepientId != other.recepientId)
		return false;
	if (recepientPhoneNumber == null) {
		if (other.recepientPhoneNumber != null)
			return false;
	} else if (!recepientPhoneNumber.equals(other.recepientPhoneNumber))
		return false;
	if (recepientname == null) {
		if (other.recepientname != null)
			return false;
	} else if (!recepientname.equals(other.recepientname))
		return false;
	return true;
}
	
   
   
}