package com.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.entity.Appearsin;
import com.entity.Cart;
import com.entity.Creditcard;
import com.entity.Customer;
import com.entity.Customizeddetails;
import com.entity.ShippingDetails;
import com.entity.Transaction;
import com.entity.product;

public interface CustomerFacade {

	
	public int registerCustomer(Customer customer);
	public Customer searchCustomer(String username, String password);
	public boolean creditcardetails(Creditcard c);
	public boolean shippingdetails(ShippingDetails s) ;
	public ArrayList<Creditcard> getAllcards(int cid);
	public ArrayList<ShippingDetails> getAllSAname(int cid);
	public int populatingcarttable(int customerid,Customizeddetails c);
	public Cart getcartinfo(int cartid);
	public int updatecustomerdetails(Customer customer);
	public boolean appearsindetails(int cartid,HashMap<Integer,Integer> h,int cid);
	public ArrayList<Appearsin> getapperaintableinfo(int cartid);
	public ArrayList<Transaction> gettransactiondetails(int cusid);
	public boolean populatecreditline(int cid,String creditline);
	
		

}
