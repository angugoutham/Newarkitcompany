package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.connection.FEBRSDbquery;
import com.connection.FEBRSNewdatabaseconnection;
import com.entity.Registeredproduct;
import com.entity.admincustomer;
import com.entity.adminquery5;
import com.entity.adminzipcode;
import com.entity.product;
import com.entity.queryone;

public class productDAO {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private FEBRSDbquery query;

	//Default constructor for injecting Spring dependencies for SQL queries
	public productDAO() {

		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContent.xml");
		query = (FEBRSDbquery) context.getBean("SqlBean");
	}
	public ArrayList<product>showAllproducts() throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<product> productList = new ArrayList<product>();
	
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getGetproducts());
	
		resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			product p = new product();
			p.setPid(resultSet.getInt("pid"));
			p.setPtype(resultSet.getString("ptype"));
			p.setPname(resultSet.getString("pname"));
			p.setDescription(resultSet.getString("description"));
			p.setCputype(resultSet.getString("cputype"));
			p.setPrintertype(resultSet.getString("printertype"));
			p.setResolution(resultSet.getString("resolution"));
			p.setBtype(resultSet.getString("btype"));
			p.setWeight(resultSet.getString("weight"));
			p.setPprice(resultSet.getInt("pprice"));
			p.setOfferprice(resultSet.getInt("offerprice"));
			p.setPquantity(resultSet.getInt("pquantity"));
			
			
		
			productList.add(p);
		}
		return productList;
		
		
	}
	
	public boolean purchaseproduct(int pid,int quantity) throws ClassNotFoundException, SQLException
	{
		
		int status;
		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateproduct());
		statement.setInt(1,quantity);
		statement.setInt(2,pid);
		status = statement.executeUpdate();
		if(status>0)
		{
		return true;
		}
		return false;
	}
	
	
	public ArrayList<queryone>  query1(String startdate,String endate) throws ClassNotFoundException, SQLException
	{

		connection = FEBRSNewdatabaseconnection.createConnection();
		
		statement = connection.prepareStatement(query.getQuery1());
		statement.setString(1, startdate);
		statement.setString(2,endate);
		ArrayList<queryone> q=new ArrayList<queryone>();
		resultSet=statement.executeQuery();
		while(resultSet.next())
		
				{
					
			queryone q1=new queryone();
			q1.setPid(resultSet.getInt("PID"));
			q1.setSum(resultSet.getInt("SUM(QUANTITY)"));
			q1.setPnmae(resultSet.getString("pname"));
			q.add(q1);
			
				}
				
				return q;
	}
	public ArrayList<queryone>  query2(String startdate,String endate) throws ClassNotFoundException, SQLException
	{

		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getQuery2());
		statement.setString(1, startdate);
		statement.setString(2,endate);
		ArrayList<queryone> q=new ArrayList<queryone>();
		resultSet=statement.executeQuery();
		while(resultSet.next())
		
				{
					
			queryone q1=new queryone();
			q1.setPid(resultSet.getInt("PID"));
			q1.setSum(resultSet.getInt("COUNT(CID)"));
			q1.setPnmae(resultSet.getString("pname"));
			q.add(q1);
			
				}
				
				return q;
	}
		
	public ArrayList<admincustomer>  query3(String startdate,String endate) throws ClassNotFoundException, SQLException
	{

		connection = FEBRSNewdatabaseconnection.createConnection();
		statement = connection.prepareStatement(query.getQuery3());
		statement.setString(1, startdate);
		statement.setString(2,endate);
		ArrayList<admincustomer> q=new ArrayList<admincustomer>();
		resultSet=statement.executeQuery();
		while(resultSet.next())
		
				{
					
			admincustomer q1=new admincustomer();
			q1.setId(resultSet.getInt("cid"));
			q1.setName(resultSet.getString("fname"));
			q1.setSum(resultSet.getInt("sum(pricesold)"));
			q.add(q1);
			
				}
				
				return q;
	}
	
public ArrayList<adminzipcode>  query4(String startdate,String endate) throws ClassNotFoundException, SQLException
{

	connection = FEBRSNewdatabaseconnection.createConnection();
	statement = connection.prepareStatement(query.getQuery4());
	statement.setString(1, startdate);
	statement.setString(2,endate);
	ArrayList<adminzipcode> q=new ArrayList<adminzipcode>();
	resultSet=statement.executeQuery();
	while(resultSet.next())
	
			{
				
				adminzipcode q1=new adminzipcode();
		q1.setZip((resultSet.getString("zip")));
		q1.setTotal(resultSet.getInt("count(*)"));
		
		q.add(q1);
		
			}
			
			return q;
}
public ArrayList<adminquery5>  query5(String startdate,String endate) throws ClassNotFoundException, SQLException
{

	connection = FEBRSNewdatabaseconnection.createConnection();
	statement = connection.prepareStatement(query.getQuery5());
	statement.setString(1, startdate);
	statement.setString(2,endate);
	ArrayList<adminquery5> q=new ArrayList<adminquery5>();
	resultSet=statement.executeQuery();
	while(resultSet.next())
	
			{
				
				adminquery5 q1=new adminquery5();
		q1.setPid((resultSet.getInt("pid")));
		q1.setPtype(resultSet.getString("ptype"));
		q1.setAverage(resultSet.getString("avg(pricesold)"));
		
		q.add(q1);
		
			}
			
			return q;
}
	

}
