 package com.entity;

import java.sql.Date;



public class Creditcard {

	int customerid;
	
	int ccNumber;
	String ownerName;
    String CCtype;
    String CCAddress;
    String ExpDate;
	int secNumber;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(int ccNumber) {
		this.ccNumber = ccNumber;
	}
	public int getSecNumber() {
		return secNumber;
	}
	public void setSecNumber(int secNumber) {
		this.secNumber = secNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCCtype() {
		return CCtype;
	}
	public void setCCtype(String cCtype) {
		CCtype = cCtype;
	}
	public String getCCAddress() {
		return CCAddress;
	}
	public void setCCAddress(String cCAddress) {
		CCAddress = cCAddress;
	}
	public String getExpDate() {
		return ExpDate;
	}
	public void setExpDate(String expDate) {
		ExpDate = expDate;
	}

    
}
