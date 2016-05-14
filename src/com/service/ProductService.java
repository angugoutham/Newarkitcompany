package com.service;

import java.sql.SQLException;
import java.util.ArrayList;



import com.entity.admincustomer;
import com.entity.adminquery5;
import com.entity.adminzipcode;
import com.entity.product;
import com.entity.queryone;

import dao.productDAO;

public class ProductService implements ProductFacade{


	@Override
	public ArrayList<product> getAllProducts() {
		// TODO Auto-generated method stub
		
productDAO pdao = new productDAO();
		
		ArrayList<product> result = null;
		
	
			
			try {
				result = pdao.showAllproducts();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
		return result; // This return value will vary depending on the coding based on Todos above. It may be ArrayList<Event[]>  
	}

	@Override
	public boolean updateproductquantity(int pid, int quantity) {
		// TODO Auto-generated method stub
		productDAO pdao = new productDAO();
		boolean result=false;
		try {
			result=pdao.purchaseproduct(pid, quantity);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<queryone> adminquery1(String fromdate, String todate) {
		// TODO Auto-generated method stub
		ArrayList<queryone> q1=null;
		productDAO pdao = new productDAO();
		
			try {
				q1=pdao.query1(fromdate, todate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return q1;
	}

	@Override
	public ArrayList<queryone> adminquery2(String fromdate, String todate) {
		// TODO Auto-generated method stub
		ArrayList<queryone> q1=null;
		productDAO pdao = new productDAO();
		
			try {
				q1=pdao.query2(fromdate, todate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return q1;
	}

	@Override
	public ArrayList<admincustomer> adminquer3(String fromdate, String todate) {
		// TODO Auto-generated method stub
		ArrayList<admincustomer> q1=null;
		productDAO pdao = new productDAO();
		
			try {
				q1=pdao.query3(fromdate, todate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return q1;
	}

	@Override
	public ArrayList<adminzipcode> adminquer4(String fromdate, String todate) {
		// TODO Auto-generated method stub
		ArrayList<adminzipcode> q1=null;
		productDAO pdao = new productDAO();
		
			try {
				q1=pdao.query4(fromdate, todate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return q1;
	}
	
	@Override
	public ArrayList<adminquery5> adminquer5(String fromdate, String todate) {
		// TODO Auto-generated method stub
		ArrayList<adminquery5> q1=null;
		productDAO pdao = new productDAO();
		
			try {
				q1=pdao.query5(fromdate, todate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return q1;
	}

}



