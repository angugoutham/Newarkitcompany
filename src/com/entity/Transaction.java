package com.entity;

import java.sql.Date;

public class Transaction {
int cartid;
int cusid;
String shiipingname;
String cardnumber;
String productsnames;
String tstatus;
public String getTstatus() {
	return tstatus;
}
public void setTstatus(String tstatus) {
	this.tstatus = tstatus;
}
public Date getTdate() {
	return tdate;
}
public void setTdate(Date tdate) {
	this.tdate = tdate;
}
Date tdate;

public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public int getCusid() {
	return cusid;
}
public void setCusid(int cusid) {
	this.cusid = cusid;
}
public String getShiipingname() {
	return shiipingname;
}
public void setShiipingname(String shiipingname) {
	this.shiipingname = shiipingname;
}
public String getCardnumber() {
	return cardnumber;
}
public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}
public String getProductsnames() {
	return productsnames;
}
public void setProductsnames(String productsnames) {
	this.productsnames = productsnames;
}

}
