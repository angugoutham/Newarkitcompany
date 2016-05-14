<%@page import="javax.websocket.Session"%>
<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.controller.Customercontroller" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
Insert title here</title>
<script src="jquery.js" ></script>
<script type="text/javascript">

function validate(productqty,productid){
	var eneteredquantity =$('#'+productid).val();
	
	var temp=productqty-eneteredquantity;
	if( eneteredquantity="")
		{
		alert("please provide product quantity");
		return false;
		}
	if(temp<=0)
		{
		alert("please provide product quantity which is avaialable");
		return false;
		}
	return true;
}</script>

</head>
<body>


			<div align="center">
			<h1>newark IT</h1></div>
			</div>

			
						<align="left"><a href="<jstlcore:url value="/index.jsp"/>">
							Logout </a><br>
							<align="right" style="width: 1033px; height: 25px"><a href='<jstlcore:url value="/creditcardregistration.jsp"/>'> Add creditcard details </a></div></div>
							
							
							
							
						
							<align="right"><a
								href="<jstlcore:url value="/shippingregistration.jsp"/>"> Add shipping details </a></div><br>
						
						
							<align="right"><a
								href="<jstlcore:url value="/updatecustomer.jsp"/>"> Update your details </a></div><br>
							
						
							
							<align="right"><a href="<jstlcore:url value="/selectcard.htm"/>"> Select your credit card</a></div><br>
						
							<align="right"><a href="<jstlcore:url value="/selectshipping.htm"/>"> Select your shipping address</a></div><br>
							<align="right"><a href="<jstlcore:url value="/oldtransaction.htm"/>"> Transaction history</a></div><br>
					
		
					<td width="1000">
					<table cellpadding="5" width="100%">
						<tr>
							<td>
							<div align="center" id="content">
							<h3> Welcome <span style="background-color: yellow;"><jstlcore:out value="${customer.getFname()}"></jstlcore:out></span> to your portal page.....</h3>
							</div>							
							<table cellpadding="4" border="1">
								<tr>
									<td width="1000">
									<div id="coursesbody" align="left">
									<p><strong>Your personal
									information</strong> 
									<p class="style1">Customerid :<jstlcore:out value="${Customer.getCid()}"></jstlcore:out></p>
									<p class="style1">Username :<jstlcore:out value="${Customer.getUsername()}"></jstlcore:out></p>
								    <p class="style1">Email: <jstlcore:out  value="${Customer.getEmail()}"></jstlcore:out></p>
									<p class="style1">Phone Number: <jstlcore:out value="${Customer.getPhone()}"></jstlcore:out></p>
									<p class="style1">Address: <jstlcore:out value="${Customer.getAddress()}"></jstlcore:out></p>
									</div>
									</td>
								</tr>
							</table>
							<div align="center"><img src="images/greenhorizontalline.jpg"
				height="5" width="100%" /></div>
			<br />
			<div id="content" align="center">
			<p class="content"><strong>select a product  to purchase <strong></p>
			<table class="content" width="96%" border="1" align="center">
				<tr bgcolor="#669966">
					<th scope="col">product id</th>
					<th scope="col">product type</th>
					<th scope="col">product name</th>
					<th scope="col">description</th>
					<th scope="col">cpu type</th>
					<th scope="col">printer type</th>
					<th scope="col">resolution </th>
					<th scope="col">batteryType</th>
					<th scope="col">weight</th>
					<th scope="col">product price </th>
					<th scope="col">offer price</th>
					<th scope="col">product quantity</th>
					<th scope="col">quantity</th>
					<th scope="col">buy</th>
					
					
					
				</tr>
				<jstlcore:forEach items="${allproducts}" var="products" >
					<tr>
					<td align="center"><jstlcore:out value="${products.getPid()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getPtype()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getPname()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getDescription()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getCputype()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getPrintertype()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getResolution()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getBtype()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getWeight()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getPprice()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getOfferprice()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${products.getPquantity()}"></jstlcore:out></td>
				<form method="get" name="logForm1" action="productpurchase.htm" onsubmit="return validate(${products.getPquantity()},${products.getPid()})">	
				<td><input type="text" name="QUANTITY" id="${products.getPid()}" size="3"></td>
				<input type="text" style=display:none name="productid" value="${products.getPid()}">
				<td><input type="submit"  value="buy" this.reset()></td>
					
					
					</form>
				
				
					
					</tr>
				</jstlcore:forEach>
				
			</table>
			
			<form method="get" name="addcart" action="addcart.htm"><input type="submit" value="checkout" size="3">
</body>
</html>