package com.service;

import java.sql.SQLException;
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

import dao.customerDAo;

public class CustomerService implements CustomerFacade {

	@Override
	public int registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		boolean insertStatus = false;		
		// TODO:  Add code here.....
		// TODO:  Pseudo-code are in the block comments above this method
		// TODO:  For more comprehensive pseudo-code with details, refer to the Component/Class Detailed Design Document
	
		customerDAo cdao  = new customerDAo();
		// tsdrfs
	
	int cid=0;
			try {
			cid=cdao.insertData(customer);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			
			
									
	
		return cid;
	}

	@Override
	public Customer searchCustomer(String username, String password) {
		// TODO Auto-generated method stub
	
		System.out.println("searchCustomer in service");

		// TODO:  Add code here.....
		// TODO:  Pseudo-code are in the block comments above this method
		// TODO:  For more comprehensive pseudo-code with details, refer to the Component/Class Detailed Design Document
		
		Customer customer = new Customer();
		customerDAo cdao  = new customerDAo();
		
		try{
		
			customer = cdao.searchUser(username, password);	
			
		}
		catch(ClassNotFoundException e){
			
			return customer = null;
		}
		catch(SQLException e){
			
			return customer = null;	
		}
		catch(Exception e){
			
			return customer = null;
		}
		
		return customer; // Replace null with "visitor" object, as required after completing the code in the TODOs above 
	}

	@Override
	public boolean creditcardetails(Creditcard credit) {
		// TODO Auto-generated method stub
		
		
		System.out.println("creditcardetails in service");
		boolean insertStatus = false;		
		// TODO:  Add code here.....
		// TODO:  Pseudo-code are in the block comments above this method
		// TODO:  For more comprehensive pseudo-code with details, refer to the Component/Class Detailed Design Document
	
		customerDAo cdao  = new customerDAo();
		
				try {
					insertStatus=cdao.insertCreditCardDetail(credit);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return insertStatus;
			
	}

	@Override
	public boolean shippingdetails(ShippingDetails shippingdetails)
	{
		System.out.println("shippingdetails in service");
		boolean insertStatus = false;		
		// TODO:  Add code here.....
		// TODO:  Pseudo-code are in the block comments above this method
		// TODO:  For more comprehensive pseudo-code with details, refer to the Component/Class Detailed Design Document
	
		customerDAo cdao  = new customerDAo();
		
				
					try {
						insertStatus=cdao.insertShippingDetials(shippingdetails);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return insertStatus;

	}

	@Override
	public ArrayList<Creditcard> getAllcards(int cid) {
		// TODO Auto-generated method stub
		System.out.println("cc number  service");
		ArrayList<Creditcard> creditcardsnumber = null;
		customerDAo cusdao=new customerDAo();
		try {
			creditcardsnumber=cusdao.getAllcardsnumber(cid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creditcardsnumber;
	}

	@Override
	public ArrayList<ShippingDetails> getAllSAname(int cid) {
		// TODO Auto-generated method stub
		System.out.println("sanames in service");
		ArrayList<ShippingDetails> Sanames = null;
		customerDAo cusdao=new customerDAo();
		try {
			Sanames=cusdao.getAllSaNames(cid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Sanames;
		
	}

	@Override
	public int populatingcarttable(int customerid, Customizeddetails c) {
		// TODO Auto-generated method stub
		
		System.out.println("populatingcarttable in service");
	int status=0;
		customerDAo cusdao=new customerDAo();
		try {
			status=cusdao.addcartdetails(customerid,c);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Cart getcartinfo(int cartid) {
		// TODO Auto-generated method stub
		Cart c=new Cart();
		customerDAo cusdao=new customerDAo();
		try {
			 c=cusdao.getcartdetails(cartid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int updatecustomerdetails(Customer customer) {
		// TODO Auto-generated method stub
		int status=0;
		customerDAo cusdao=new customerDAo();
		try {
			status=cusdao.updatecustomerinfo(customer);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public boolean appearsindetails(int cartid, HashMap<Integer, Integer> h,int cid) {
		// TODO Auto-generated method stub
		customerDAo c=new customerDAo();
		try {
			c.appearsintableinsert(cartid, h, cid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Appearsin> getapperaintableinfo(int cartid) {
		// TODO Auto-generated method stub
		ArrayList<Appearsin> appersindetails=new ArrayList<Appearsin>();
		customerDAo c=new customerDAo();
		try {
			appersindetails=c.getappearsindata(cartid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appersindetails;
		
		
	}

	@Override
	public ArrayList<Transaction> gettransactiondetails(int cusid)
	{
		// TODO Auto-generated method stub
		ArrayList<Transaction> appersindetails=new ArrayList<Transaction>();
		customerDAo c=new customerDAo();
		try {
			appersindetails=c.getoldtrans(cusid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appersindetails;
	
		
		
		

	}

	@Override
	public boolean populatecreditline(int cid,String creditline) {
		// TODO Auto-generated method stub
		boolean status=false;
		customerDAo c=new customerDAo();
		try {
			status=c.insertintocreditline(cid,creditline);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
		
		
		
	}

	
}
