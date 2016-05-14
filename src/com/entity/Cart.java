package com.entity;

public class Cart {
	int cartid; 
	int cid;
	String shippingaddressname;
	String ccnumber;
	String tstatus;
	String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getShippingaddressname() {
		return shippingaddressname;
	}
	public void setShippingaddressname(String shippingaddressname) {
		this.shippingaddressname = shippingaddressname;
	}
	public String getCcnumber() {
		return ccnumber;
	}
	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}
	public String getTstatus() {
		return tstatus;
	}
	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}
	
}
