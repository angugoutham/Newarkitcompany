package com.controller;






 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.naming.java.javaURLContextFactory;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.entity.Appearsin;
import com.entity.Cart;
import com.entity.Creditcard;
import com.entity.Customer;
import com.entity.Customizeddetails;
import com.entity.Registeredproduct;
import com.entity.ShippingDetails;
import com.entity.Transaction;
import com.entity.admincustomer;
import com.entity.adminquery5;
import com.entity.adminzipcode;
import com.entity.product;
import com.entity.queryone;
import com.exceptions.FERSGenericException;
import com.service.CustomerFacade;
import com.service.CustomerService;
import com.service.ProductFacade;
import com.service.ProductService;

/**
 *	<br/>
 *	CLASS DESCRIPTION:  <br/>
 *	A controller class for receiving and handling all visitor related transactions from the 
 *  User Interface including visitor account access, visitor account maintenance,  
 *  and visitor event registration requests. <br/>
 *  
 */

@Controller
public class Customercontroller 
{

	Customizeddetails cusdetails=new Customizeddetails();
	HashMap<Integer,Integer> dataset=new HashMap<Integer,Integer>();
	ArrayList<Registeredproduct> reglist=new ArrayList<Registeredproduct>();
	/** 
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * This method will receive request from Registration.jsp and directs to
	 * service class to register new Visitor into system
	 * by accepting details and persist into database <br/>
	 * 
	 * @param request (type HttpServletRequest)
	 * @param response (type HttpServletResponse)
	 * 
	 * @return ModelAndView
	 * @throws ParseException 
	 * 
	 * @throws FERSGenericException
	 * 
	 * 
	 */
	
	public String  Formatdate(String s) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Date startDate = df.parse(s);
		  SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/mm/dd");
		    String strDate = sdfDestination.format(startDate);
		   
		return strDate;
		
	}
	@RequestMapping("/admincontroller.htm")
	public ModelAndView adminpage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		
		
		String Startdate=request.getParameter("StartDate");
	String Enddate=request.getParameter("EndDate");

	String fromdate=Formatdate(Startdate);
	String todate=Formatdate(Enddate);
	String query=request.getParameter("S");


	ProductService p=new ProductService();
	ModelAndView m=new ModelAndView();
	if(query.equalsIgnoreCase("Frequentlysold"))
	{
	ArrayList<queryone> q=p.adminquery1(fromdate, todate);
	m.addObject("value",q);
	m.setViewName("query1");
	}
	else
	{
		if(query.equalsIgnoreCase("DistinctCustomers"))
		{
		ArrayList<queryone> q=p.adminquery2(fromdate, todate);
		m.addObject("value",q);
		m.setViewName("query1");
		}
	}
	
	
		
		if(query.equalsIgnoreCase("Best Customers"))
		{
			ArrayList<admincustomer> q=p.adminquer3(fromdate, todate);
			m.addObject("value",q);
			m.setViewName("query3");
		}
		if(query.equalsIgnoreCase("5 Best Zip"))
	
		{
			ArrayList<adminzipcode> q=p.adminquer4(fromdate, todate);
			m.addObject("value",q);
			m.setViewName("query4");
		}
		if(query.equalsIgnoreCase("Average product price"))
			
		{
			ArrayList<adminquery5> q=p.adminquer5(fromdate, todate);
			m.addObject("value",q);
			m.setViewName("adminquery5");
		}
		

	
		return m;
		
		
	}
	@RequestMapping("/newVistor.htm")
	public ModelAndView newcustomer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("entering newVistor controller");
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		String username=request.getParameter("USERNAME");
	    String password=request.getParameter("PASSWORD");
		String firstname=request.getParameter("FIRSTNAME");
		String lastname=request.getParameter("LASTNAME");
		String email=request.getParameter("EMAIL");
		String phoneno=request.getParameter("PHONENO");
		String address=request.getParameter("ADDRESS");
		String status=request.getParameter("STATUS");
		String creditline=request.getParameter("mydropdown");
		
		System.out.println(creditline);
		
		
		Customer customer=new Customer();
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setFname(firstname);
		customer.setLname(lastname);
		customer.setEmail(email);
		customer.setPhone(phoneno);
		customer.setAddress(address);
		customer.setStatus(status);
		
		CustomerFacade cServiceimpl=new CustomerService();
		int cid=cServiceimpl.registerCustomer(customer);
		boolean insertStatus=cServiceimpl.populatecreditline(cid,creditline);
		ModelAndView mv=new ModelAndView();
		if(insertStatus==true)
		{
		mv.addObject("REGISTRATIONSTATUSMESSAGE", "User Registered Succesfully !!!");
		mv.setViewName("registration");
		System.out.println("sucess newVistor controller");
		}
		else
		{
		mv.addObject("REGISTRATIONSTATUSMESSAGE", "USERNAME already exists.. please register again with different USERNAME..");
		mv.setViewName("registration");
		System.out.println("failed newVistor controller");
		}
		System.out.println(mv.getViewName().toString());
		return mv;
		
	}
@RequestMapping("/updatecustomer.htm")
	public ModelAndView updatecustomer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("entering update controller");
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("Customer");
		
		
		String username=request.getParameter("username");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		String place=request.getParameter("address");
		String status=request.getParameter("status");
		System.out.println(status);
		System.out.println(customer.getCid());;
		
		customer.setFname(firstname);
		customer.setLname(lastname);
		customer.setUsername(username);
		customer.setEmail(email);
		customer.setPhone(phoneno);
		customer.setAddress(place);
		customer.setStatus(status);
		
	
		CustomerService customerservice=new CustomerService();
		
		
		int status1=customerservice.updatecustomerdetails(customer);

		
		ModelAndView mv=new ModelAndView();
		
		if(status1>0)
		{
			mv.addObject("updatestatus","success");
			mv.setViewName("/updatecustomer");
		}
		else
		{
			mv.addObject("updatestatus", "Error in updation.. Please Check fields and retry");
			mv.setViewName("/updatecustomer");
		}				
		return mv;
	}	
	
	
	@RequestMapping("/searchCustomer.htm")
	public ModelAndView searchVisitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		String username=request.getParameter("CustomerName");
		
		String password=request.getParameter("PASSWORD");
		HttpSession hs=request.getSession();
		ModelAndView mv=new ModelAndView();
		if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
		{
		
			mv.setViewName("/admin");
		}
		
		else 
		{

		if(hs.isNew())
		{
			hs.setAttribute("CustomerName", username);
			hs.setAttribute("PASSWORD", password);
		}
		/*else
		{
			username=hs.getAttribute("CustomerName").toString();
			password=hs.getAttribute("PASSWORD").toString();
		}
		
		*/
		
		Customer customer=new Customer();
		
		CustomerFacade cServiceImpl=new CustomerService();
		customer=cServiceImpl.searchCustomer(username, password);
		System.out.println(customer.getUsername());
		HttpSession session=request.getSession();
		
		HashMap<Integer,Integer> dataset=new HashMap<Integer,Integer>();
session.setAttribute("dataset", dataset);
		//ModelAndView mv=new ModelAndView();
		
		if(customer.getCid()==0)
		{
			mv.addObject("ERROR","Invalid Username / Password.");
			mv.setViewName("/index");
			return mv;
		}
		else
		{
			product prod=new product();
			ArrayList<product> result;
			ProductFacade pServiceImpl=new ProductService();
			result=pServiceImpl.getAllProducts();
		
		session.setAttribute("Customer", customer);
		
				System.out.println("login working in database");
		mv.addObject("Customer", customer);
		mv.addObject("allproducts",result);
		//mv.addObject("regEvents",regList);
		mv.setViewName("/Customermain");
		
		}
	
	}
		return mv;
	}
	@RequestMapping("/viewcustomer.htm")
	public ModelAndView viewcustomerpage(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	
		  Customer customer=(Customer)request.getSession().getAttribute("Customer");
		  product prod=new product();
		  
			ArrayList<product> result;
			ProductFacade pServiceImpl=new ProductService();
			result=pServiceImpl.getAllProducts();
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("Customer", customer);
			mv.addObject("allproducts",result);
			//mv.addObject("regEvents",regList);
			//mv.addObject("allproducts",result);
			mv.setViewName("/Customermain");
	
			return mv;
		
	}
	
		
	
	@RequestMapping("/newcreditcard.htm")
	public ModelAndView creditcard(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		System.out.println("entering newcreditcard.htm");
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		Customer customer= (Customer) session.getAttribute("Customer");
		System.out.println(customer.getCid());
		int customerid=customer.getCid();
		String creditcardnumber1=request.getParameter("ccnumber");
	    String sectionumber1=request.getParameter("Sectionnumber");
		String ownername=request.getParameter("ownername");
		String creditcarttype=request.getParameter("cctype");
		String creditcardaddress=request.getParameter("ccaddress");
		String Expdate=request.getParameter("edate");
	
		int creditcardnumber = Integer.parseInt(creditcardnumber1);
		int sectionnumber=Integer.parseInt(sectionumber1);
		
		   
		   Creditcard creditcard=new Creditcard();
		   creditcard.setCustomerid(customerid);
		   creditcard.setCcNumber(creditcardnumber);
		   creditcard.setSecNumber(sectionnumber);
		   creditcard.setOwnerName(ownername);
		   creditcard.setCCtype(creditcarttype);
		   creditcard.setCCAddress(creditcardaddress);
		   creditcard.setExpDate(Expdate);
		   CustomerFacade cServiceimpl=new CustomerService();
		   boolean creditcardstatus=cServiceimpl.creditcardetails(creditcard);
		   
		   
		   ModelAndView mv=new ModelAndView();
			if(creditcardstatus==true)
			{
			mv.addObject("CREDITCARDREGISTRATIONSTATUSMESSAGE", "creditcard  Registered Succesfully !!!");
			mv.setViewName("creditcardregistration");
			System.out.println("newcreditcard.htm sucess");
			}
			else
			{
			mv.addObject("CREDITCARDREGISTRATIONSTATUSMESSAGE", "creditcard NUMBER already exists.. please register again with different USERNAME..");
			mv.setViewName("creditcardregistration");
			System.out.println("newcreditcard.htm error");
			}
			System.out.println(mv.getViewName().toString());
			return mv;
			
		
		   
		   
		
	}

	@RequestMapping("/shippingdetails.htm")
	public ModelAndView shippingDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		System.out.println("entering shippingdetails.htm");
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		HttpSession session=request.getSession();
		Customer customer= (Customer) session.getAttribute("Customer");
		System.out.println(customer.getCid());
		int customerid=customer.getCid();
		String shippingaddressname=request.getParameter("SAName");
	    String recepientname=request.getParameter("RecepientName");
		String street=request.getParameter("street");
		String snumber=request.getParameter("StreetNumber");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
	
		
	
		   
		   
		   ShippingDetails shippingdetails=new ShippingDetails();
		   shippingdetails.setCustomerid(customerid);
		   shippingdetails.setSaName(shippingaddressname);
		   shippingdetails.setRecipetName(recepientname);
		   shippingdetails.setStreet(street);
		   shippingdetails.setsNumber(snumber);
		   shippingdetails.setCity(city);
		   shippingdetails.setState(state);
		   shippingdetails.setCountry(country);
		   shippingdetails.setZip(zip);
		
		   CustomerFacade cServiceimpl=new CustomerService();
		   boolean shippingdetailsstatus=cServiceimpl.shippingdetails(shippingdetails);
		   
		   
		   ModelAndView mv=new ModelAndView();
			if(shippingdetailsstatus==true)
			{
			mv.addObject("SHIPPINGDETAILSSTATUSMESSAGE", "shipping details  Registered Succesfully !!!");
			mv.setViewName("shippingregistration");
			System.out.println("shippingregistration.htm sucess");
			}
			else
			{
			mv.addObject("SHIPPINGDETAILSSTATUSMESSAGE", "shipping details already exists.. please register again with different USERNAME..");
			mv.setViewName("shippingregistration");
			System.out.println("shippingregistration.htm error");
			}
			System.out.println(mv.getViewName().toString());
			return mv;
			
		
		   
		   
		
	}

	@RequestMapping("/productpurchase.htm")
	public ModelAndView registeredproduct(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
		
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		System.out.println("hitting productpurchase module customer");
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("Customer");
		int customer_id=customer.getCid();
		int pid=Integer.parseInt((request.getParameter("productid")));
		int qty=Integer.parseInt((request.getParameter("QUANTITY")));
		Registeredproduct registeredprod=new Registeredproduct();
		registeredprod.setSelectedproduct_id(pid);
		registeredprod.setSelectedquantity(qty);
		dataset=(HashMap)session.getAttribute("dataset");
		if(dataset.containsKey(pid))
		{
			int temp=dataset.get(pid);
			temp=temp+qty;
			System.out.println(temp);
			dataset.put(pid, temp);
		}
		else
		{
			dataset.put(pid, qty);
		}
		for (Entry<Integer, Integer> entry : dataset.entrySet()) 
		{
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		System.out.println("hashmap size"+dataset.size());
		System.out.println(registeredprod.getSelectedquantity());
		reglist.add(registeredprod);
		ProductService prodservice=new ProductService();
		boolean status=prodservice.updateproductquantity(pid, qty);
		ModelAndView mv=new ModelAndView();
		if (status==true)
		{
			product prod=new product();
			ArrayList<product> result;
			ProductFacade pServiceImpl=new ProductService();
			result=pServiceImpl.getAllProducts();
			session.setAttribute("Customer", customer);
			mv.addObject("Customer", customer);
			mv.addObject("allproducts",result);
			//mv.addObject("regEvents",regList);
			mv.setViewName("/Customermain");
		}
		else
		{
			
			
			mv.addObject("PRODUCTQUANTITYERRORMESSAGE","product out of stock");
		}
		//now write logic to reduce the quantity 
		System.out.println(reglist.size());
		return mv;
}
	@RequestMapping("/selectcard.htm")
public ModelAndView selectcards(HttpServletRequest request,
		HttpServletResponse response) throws Exception{

	System.out.println("entering newcreditcard.htm");
	if(request==null || response==null)
	{
		
		throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
	}
	
	HttpSession session=request.getSession();
	Customer customer= (Customer) session.getAttribute("Customer");
	System.out.println(customer.getCid());
	int customerid=customer.getCid();
	CustomerFacade cServiceimpl=new CustomerService();
	ArrayList<Creditcard> result=cServiceimpl.getAllcards(customerid);
	System.out.println("no of cards"+result.size());
	 ModelAndView mv=new ModelAndView();
	 mv.addObject("registeredcards", result);
	 mv.setViewName("/selectcard");
	 
return mv;
}
	@RequestMapping("/cardselect.htm")
	public ModelAndView cardselected(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("returning");
		HttpSession session=request.getSession();
		String selectedcard=request.getParameter("selectedcard");
		System.out.println(selectedcard);
		cusdetails.setSelectedcardnumber(selectedcard);
		 ModelAndView mv=new ModelAndView();
		mv.addObject("CARDSELECTEDSUCESSFULLY", "creditcard  selected Succesfully !!!");
		mv.setViewName("/selectcard");
		return mv;

	}

	
	@RequestMapping("/selectshipping.htm")
	public ModelAndView selectshipping(HttpServletRequest request,
			HttpServletResponse response) throws Exception{

		System.out.println("entering selectshipping.htm");
		if(request==null || response==null)
		{
			
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		
		HttpSession session=request.getSession();
		Customer customer= (Customer) session.getAttribute("Customer");
		System.out.println(customer.getCid());
		int customerid=customer.getCid();
		CustomerFacade cServiceimpl=new CustomerService();
		ArrayList<ShippingDetails> result=cServiceimpl.getAllSAname(customerid);
		System.out.println("hello");
		System.out.println("no of shippingaddress"+result.size());
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("registeredshippingaddress", result);
		 mv.setViewName("/selectshippingaddress");
		 
	return mv;
	}
	@RequestMapping("/shippingaddressselected.htm")
	public ModelAndView shippingaddressselected(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("returning");
		HttpSession session=request.getSession();
		String selectedshippingAddress=(request.getParameter("selectedaddress"));
		System.out.println(selectedshippingAddress);
		cusdetails.setSelectedshippinngaddresnumber(selectedshippingAddress);
		 ModelAndView mv=new ModelAndView();
			mv.addObject("SHIPPINGADDRESSSELECTEDSUCESSFULLY", "shipping address  selected Succesfully !!!");
			mv.setViewName("/selectshippingaddress");
			
		return mv;

	}
@RequestMapping("/addcart.htm")
	public ModelAndView addintocart(HttpServletRequest request,
			HttpServletResponse response) throws FERSGenericException{
		

	System.out.println("entering shippingdetails.htm");
	if(request==null || response==null)
	{
		
		throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
	}
	HttpSession session=request.getSession();
	Customer customer= (Customer) session.getAttribute("Customer");
	System.out.println(customer.getCid());
	int customerid=customer.getCid();
	CustomerService cusservice=new CustomerService();
	int cartid=cusservice.populatingcarttable(customerid, cusdetails);
	boolean status=cusservice.appearsindetails(cartid, dataset,customerid);
	ArrayList<Appearsin> appearsintableinfo=cusservice.getapperaintableinfo(cartid);
	System.out.println("dataset");
	//give this cart id and that data set for populating in to aeepas in table
	ModelAndView mv=new ModelAndView();
	Cart cart1=new Cart();
	 cart1=cusservice.getcartinfo(cartid);
	if(cartid>0)
	{
	//mv.addObject("SHIPPINGDETAILSSTATUSMESSAGE", "shipping details  Registered Succesfully !!!");
		
	
		mv.addObject("cartdetails", cart1);
		mv.addObject("appersindata",appearsintableinfo);
	mv.setViewName("cart");
	System.out.println("cart adding sucess sucess");
	}
	else
	{
	
		mv.setViewName("cart");
		System.out.println("cart adding  failuere sucess sucess");
	}

	return mv;
	}
@RequestMapping("/oldtransaction.htm")
public ModelAndView oldtrans(HttpServletRequest request,
		HttpServletResponse response) throws FERSGenericException{
	System.out.println("entering shippingdetails.htm");
	if(request==null || response==null)
	{
		
		throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
	}
	HttpSession session=request.getSession();
	Customer customer= (Customer) session.getAttribute("Customer");
	System.out.println(customer.getCid());
	int customerid=customer.getCid();
	CustomerService cusservice=new CustomerService();
ArrayList<Transaction> trans=new ArrayList<Transaction>();
trans=cusservice.gettransactiondetails(customerid);

ModelAndView mv=new ModelAndView();
mv.addObject("trans", trans);

mv.setViewName("old");
	return mv;
}
}