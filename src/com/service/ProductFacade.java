package com.service;

import java.util.ArrayList;

import com.entity.admincustomer;
import com.entity.adminquery5;
import com.entity.adminzipcode;
import com.entity.product;
import com.entity.queryone;



public interface ProductFacade {

	public ArrayList<product> getAllProducts(); 
	public boolean updateproductquantity(int pid,int quantity);
	
	public  ArrayList<queryone> adminquery1(String fromdate,String todate);
	public  ArrayList<queryone> adminquery2(String fromdate,String todate);
	public  ArrayList<admincustomer> adminquer3(String fromdate,String todate);
	public  ArrayList<adminzipcode> adminquer4(String fromdate,String todate);
	public  ArrayList<adminquery5> adminquer5(String fromdate,String todate);
	}
	
	

