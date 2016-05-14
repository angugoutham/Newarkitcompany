package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.connection.FEBRSDbquery;
import com.connection.FEBRSNewdatabaseconnection;


import com.entity.Appearsin;
import com.entity.Cart;
import com.entity.Creditcard;
import com.entity.Customer;
import com.entity.Customizeddetails;
import com.entity.Registeredproduct;
import com.entity.ShippingDetails;
import com.entity.Transaction;
import com.entity.product;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public class customerDAo {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private FEBRSDbquery query;

	//Default constructor for injecting Spring dependencies for SQL queries
	public customerDAo() {

		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContent.xml");
		query = (FEBRSDbquery) context.getBean("SqlBean");
	}

	
	public int insertData(Customer customer ) throws ClassNotFoundException,
	SQLException,MySQLIntegrityConstraintViolationException, Exception {
		int status = 0;	

connection = FEBRSNewdatabaseconnection.createConnection();
statement = connection.prepareStatement(query.getInsertQuery(),Statement.RETURN_GENERATED_KEYS);

statement.setString(1, customer.getFname());
statement.setString(2, customer.getLname());
statement.setString(3, customer.getUsername());
statement.setString(4,customer.getPassword().toString());	
statement.setString(5, customer.getEmail());
statement.setString(6, customer.getAddress());
statement.setString(7, customer.getPhone());
statement.setString(8, customer.getStatus());



		int cusid=0;
	status = statement.executeUpdate();
	resultSet=statement.getGeneratedKeys();
	while (resultSet.next())
	{
		cusid=resultSet.getInt(1);
		System.out.println(cusid);
	}

	FEBRSNewdatabaseconnection.closeConnection();

	if (status > 0) {
		return cusid;
	}
	else{
		return 0;
	}

	}

	public boolean insertintocreditline(int cid,String creditline) throws ClassNotFoundException, SQLException
	{
		
		connection = FEBRSNewdatabaseconnection.createConnection();
	statement = connection.prepareStatement(query.getInserintocreditline());
	statement.setInt(1, cid);
	statement.setString(2, creditline);
	
	inmysql -u root -pt status=statement.executeUpdate();
	if(status>0)
	{
			return true;
		
		
	}
	return false;
	}
	public int updatecustomerinfo(Customer c) throws ClassNotFoundException, SQLException
	{
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateQuery());
		statement.setString(1, c.getFname());
		statement.setString(2, c.getLname());
		statement.setString(3, c.getUsername());
		
		statement.setString(4, c.getEmail());
		statement.setString(5, c.getAddress());
		statement.setString(6,c.getPhone());
		statement.setString(7, c.getStatus());
		statement.setInt(8, c.getCid());

		int status = statement.executeUpdate();
		
		FEBRSNewdatabaseconnection.closeConnection();

		return status;
		
		
	}
	public Customer searchUser(String username,String password ) throws ClassNotFoundException, SQLException
	{

		Customer e = new Customer();
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getSearchQuery());
		statement.setString(1, username);
		statement.setString(2, password);
		resultSet = statement.executeQuery();

		while(resultSet.next())
		{
			e.setCid(resultSet.getInt("cid"));
			e.setFname(resultSet.getString("fname"));
			e.setLname(resultSet.getString("lname"));
			e.setUsername(resultSet.getString("username"));
			e.setEmail(resultSet.getString("email"));
			e.setAddress(resultSet.getString("address"));
			e.setPhone(resultSet.getString("phone"));
			e.setStatus(resultSet.getString("status"));
		
		}
		System.out.println("check1");
		return e;
		
	}

	
	public boolean insertCreditCardDetail(Creditcard creditcard ) throws ClassNotFoundException, SQLException
	{
		int status=0;
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getInsertcreditcardQuery());
		statement.setInt(1, creditcard.getCustomerid());
		statement.setInt(2, creditcard.getCcNumber());
		statement.setInt(3, creditcard.getSecNumber());
		statement.setString(4, creditcard.getOwnerName());
		statement.setString(5,creditcard.getCCtype());	
		statement.setString(6, creditcard.getCCAddress());
		statement.setString(7, creditcard.getExpDate());
		status = statement.executeUpdate();
		if (status > 0) {

			return true;
			
		}
		else{
			return false;
		}
		
		
	}

 public boolean insertShippingDetials(ShippingDetails shippingdetails ) throws ClassNotFoundException, SQLException 
 {
	 int status=0;
	 connection = FEBRSNewdatabaseconnection.createConnection();
	 statement = connection.prepareStatement(query.getInsertshippingdetails());
	 statement.setInt(1,shippingdetails.getCustomerid());
	 statement.setString(2, shippingdetails.getSaName());
	 statement.setString(3, shippingdetails.getRecipetName());
	 statement.setString(4, shippingdetails.getStreet());
	 statement.setString(5,shippingdetails.getsNumber());	
	 statement.setString(6, shippingdetails.getCity());
	 statement.setString(7, shippingdetails.getZip());
	 statement.setString(8, shippingdetails.getState());
	 statement.setString(9, shippingdetails.getCountry());
	 status = statement.executeUpdate();


		FEBRSNewdatabaseconnection.closeConnection();

		if (status > 0) {
			return true;
		}
		else{
			return false;
		}
	 
	}
		
	
	
	public ArrayList<Creditcard> getAllcardsnumber(int cid) throws ClassNotFoundException, SQLException{
		ArrayList<Creditcard> Creditcardnumberlist = new ArrayList<Creditcard>();
		connection = FEBRSNewdatabaseconnection.createConnection();
		 statement = connection.prepareStatement(query.getGetcreditcardnumber());
		statement.setInt(1, cid);
		resultSet=statement.executeQuery();
		while(resultSet.next())
		{
		
			Creditcard creditcardnumber= new Creditcard();
			creditcardnumber.setCcNumber(resultSet.getInt("creditcardnumber"));
			Creditcardnumberlist.add(creditcardnumber);
		}
		return Creditcardnumberlist;
	}
	
	public ArrayList<ShippingDetails> getAllSaNames(int cid) throws ClassNotFoundException, SQLException{
		ArrayList<ShippingDetails> Sanames = new ArrayList<ShippingDetails>();
		connection = FEBRSNewdatabaseconnection.createConnection();
		 statement = connection.prepareStatement(query.getGetshippingname());
		statement.setInt(1, cid);
		resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			
			ShippingDetails SaNames= new ShippingDetails();
			SaNames.setSaName(resultSet.getString("saname"));
			Sanames.add(SaNames);
		}
		return Sanames;
	}

	public int addcartdetails(int cid,Customizeddetails c) throws ClassNotFoundException, SQLException
	{
		System.out.println("enetering addcartdetails dao");
		int status=0;
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getInsertintocart(),Statement.RETURN_GENERATED_KEYS);
		
		String saname=c.getSelectedshippinngaddresnumber();
		String cardnumber=c.getSelectedcardnumber();
		Calendar calendar = Calendar.getInstance();
		 int cartid=0;

		java.util.Date currentDate = calendar.getTime();

		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		
		statement.setInt(1, cid);
		statement.setString(2, saname);
		statement.setString(3,cardnumber);
		statement.setString(4,"shipped");
		statement.setDate(5,sqlDate);
		status=statement.executeUpdate();
		resultSet=statement.getGeneratedKeys();
		while (resultSet.next())
		{
			cartid=resultSet.getInt(1);
			System.out.println(cartid);
		}
		if(status>0)
		{
			return cartid;
		}
		
		return 0;
		
	}
	
	public Cart getcartdetails(int cartid) throws SQLException, ClassNotFoundException{
		
		connection = FEBRSNewdatabaseconnection.createConnection();
		 statement = connection.prepareStatement(query.getGetcartinfo());
		 statement.setInt(1, cartid);
		 resultSet=statement.executeQuery();
		 Cart c=new Cart();
		while(resultSet.next())
		{
		;
		c.setCartid(resultSet.getInt("cartid"));
		c.setCid(resultSet.getInt("cid"));
		c.setShippingaddressname(resultSet.getString("shippingaddressname"));
		c.setCcnumber(resultSet.getString("ccnumber"));
		c.setTstatus(resultSet.getString("tstatus"));
		c.setDate(resultSet.getDate("tdate").toString());
		
		
	}
		return c;
		
	}
	
	public int getofferprice(int pid) throws ClassNotFoundException, SQLException
	{
		connection = FEBRSNewdatabaseconnection.createConnection();
	
		statement=connection.prepareStatement(query.getGetofferprice());
		statement.setInt(1, pid);
		int  result=0;
		resultSet=statement.executeQuery();
	
		while(resultSet.next())
		{
			
			 result=resultSet.getInt("offerprice");
			
				
			}
		return result;
		}
	
	
	public int getactualpprice(int pid) throws ClassNotFoundException, SQLException
	{
		connection = FEBRSNewdatabaseconnection.createConnection();
	
		statement=connection.prepareStatement(query.getGetactualprice());
		statement.setInt(1, pid);
		resultSet=statement.executeQuery();
		
		int result=0;
		while(resultSet.next())
		{
			
			 result=resultSet.getInt("pprice");
			
				
			}
		return result ;
		}
	
	
	
	public boolean appearsintableinsert(int cartid,HashMap<Integer,Integer> hashmap,int cid) throws ClassNotFoundException, SQLException
	{
	
		List<Registeredproduct> regprod=new ArrayList<Registeredproduct>();
		
		for (Entry<Integer, Integer> entry : hashmap.entrySet()) 
		{
			Registeredproduct r= new Registeredproduct();
		    int pid= entry.getKey();
		     int qty=entry.getValue();
		     r.setSelectedproduct_id(pid);
		     r.setSelectedquantity(qty);
		     regprod.add(r);
		}
		List<Appearsin> appears_in=new ArrayList<Appearsin>();
		String credit=getcreditlinestatus(cid);
		   Iterator itr = regprod.iterator();
		while(itr.hasNext())
		{
			Registeredproduct r= (Registeredproduct) itr.next();
			Appearsin appearsin=new Appearsin();
			int productid=r.getSelectedproduct_id();
			
			int quantity=r.getSelectedquantity();

			
			int actual=getactualpprice(productid);
	
			int offer=getofferprice(productid);
			
			int price=(offer>0 &&offer<actual)?offer:actual;
			
			if(credit.equalsIgnoreCase("Gold"))
			{
				price=price-100;
			}
			else if(credit.equalsIgnoreCase("platinum"))
			{
				price=price-150;
			}
			int pricesold=quantity*price;
			
			appearsin.setCardid(cartid);
			appearsin.setPid(productid);
			appearsin.setQuantity(quantity);
			appearsin.setPricesold(pricesold);
					
			appears_in.add(appearsin);
			
			
		}
		
		 
		 
		Iterator mainitr = appears_in.iterator();
		while(mainitr.hasNext())
		{
			Appearsin a=(Appearsin) mainitr.next();
			
			int status=0;
			connection = FEBRSNewdatabaseconnection.createConnection();
			statement = connection.prepareStatement(query.getInsertappears());
			statement.setInt(1, a.getCardid());
			statement.setInt(2, a.getPid());
			statement.setInt(3, a.getQuantity());
			statement.setInt(4, a.getPricesold());
			
			status=statement.executeUpdate();
			
			System.out.println(status);
			
			
		}
		return true;
		
	}
	public String getcreditlinestatus(int cid) throws ClassNotFoundException, SQLException
	{

		 Connection connection3 = FEBRSNewdatabaseconnection.createConnection();;
		 PreparedStatement statement3= connection3.prepareStatement(query.getGetcreditline());;
		 
		 statement3.setInt(1, cid);
		 ResultSet resultSet3 = statement3.executeQuery();
		 String creditline="silver";
			while(resultSet3.next())
			{
				 creditline=resultSet3.getString("creditline");
				
			}
			System.out.println(creditline);
		return creditline;
	}

	public ArrayList<Appearsin> getappearsindata(int cartid) throws ClassNotFoundException, SQLException
	{
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getGetallproductdetails());
		statement.setInt(1, cartid);
		ArrayList<Appearsin> a=new ArrayList<Appearsin>();
		resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			Appearsin appearsin=new Appearsin();
			appearsin.setCardid(resultSet.getInt("cartid"));
			appearsin.setPid(resultSet.getInt("pid"));
			appearsin.setQuantity(resultSet.getInt("quantity"));
			appearsin.setPricesold(resultSet.getInt("pricesold"));
			a.add(appearsin);
			
		}
		
		
		
		return a;
		
		
	}
	public StringBuilder productsnamepurchase(int cartid,Connection connection) throws ClassNotFoundException, SQLException
	{
		

	//	connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getGetpurcahseproductname());
		
		statement.setInt(1, cartid);
	ResultSet	resultSet1=statement.executeQuery();
	
		 StringBuilder result = new StringBuilder();
		while (resultSet1.next())
		{
			String temp=resultSet1.getString("pname");
			
			result.append(temp);
			result.append(",");
		
			
		}
		return result;
	}

	
	public ArrayList<Transaction> getoldtrans(int cusid) throws SQLException, ClassNotFoundException
	{
		
		
		connection = FEBRSNewdatabaseconnection.createConnection();
		 
		statement = connection.prepareStatement(query.getGetoldertransaction());
		statement.setInt(1,cusid);
		
	String s=statement.toString();
	System.out.println(s);
		ArrayList<Transaction> t=new ArrayList<Transaction>();
		resultSet=statement.executeQuery();
		//int cartid1;
		//resultSet.last();
		//int m=resultSet.getRow();
		//System.out.println("row"+m);
	
		while(resultSet.next())
		{
			
			Transaction tr=new Transaction();

		
			int cartid1=resultSet.getInt("cartid");
			System.out.println("cartid"+cartid1);
			tr.setCartid(cartid1);
			tr.setShiipingname(resultSet.getString("shippingaddressname"));
			tr.setCardnumber(resultSet.getString("ccnumber"));
			tr.setTstatus(resultSet.getString("tstatus"));
			tr.setTdate(resultSet.getDate("tdate"));
			tr.setProductsnames(productsnamepurchase(cartid1,connection).toString());
			t.add(tr);
			
		}
		
		return t;
		
		
		
	}
}

