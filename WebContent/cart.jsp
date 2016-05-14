<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right" >
<a href="viewcustomer.htm">go to home</a>
</div>
<table cellpadding="5" width="100%">
						<tr>
							<td>
							<div align="left" id="content">
							<h3> Cart details</h3>
							</div>							
							<table cellpadding="4" border="1">
								<tr>
									<td width="1000">
									<div id="coursesbody" align="left">
									<p><strong>Your cart information</strong> 
									<p class="style1">cardtid :<jstlcore:out value="${cartdetails.getCartid()}"></jstlcore:out></p>
									<p class="style1">customerid :<jstlcore:out value="${cartdetails.getCid()}"></jstlcore:out></p>
								    <p class="style1">shipping addres name: <jstlcore:out  value="${cartdetails.getShippingaddressname()}"></jstlcore:out></p>
									<p class="style1">credit card Number: <jstlcore:out value="${cartdetails.getCcnumber()}"></jstlcore:out></p>
									<p class="style1">transaction status: <jstlcore:out value="${cartdetails.getTstatus()}"></jstlcore:out></p>
									<p class="style1">transaction date: <jstlcore:out value="${cartdetails.getDate()}"></jstlcore:out></p>
									</div>
									</td>
								</tr>
							</table>
						
							<br>
							<br>
							<h1>Details of your current purchase</h1>
								<table class="content" width="96%" border="1" align="left">
											
							
								<tr>
									
									
					<th scope="col">cart id </th>
					<th scope="col">product id</th>
					<th scope="col">quantity</th>
					<th scope="col">pricesold</th>
									</tr>
									<jstlcore:forEach items="${appersindata}" var="appearsin" >
					<tr>
					<td align="center"><jstlcore:out value="${appearsin.getCardid()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${appearsin.getPid()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${appearsin.getQuantity()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${appearsin.getPricesold()}"></jstlcore:out></td>
							</tr>	
									</jstlcore:forEach>	
									
									</table>
							 
							
</body>
</html>