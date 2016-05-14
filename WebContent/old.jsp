<%@page import="javax.websocket.Session"%>
<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.controller.Customercontroller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




							<br>
							<br>
							<h1>Details of your current purchase</h1>
								<table class="content" width="96%" border="1" align="left">
											
							
								<tr>
									
									
					<th scope="col">cart id </th>
					<th scope="col">shipping address name </th>
					<th scope="col">credit card</th>
					<th scope="col">transaction date</th>
					<th scope="col">transaction status </th>
					<th scope="col">products bought </th>
					
									</tr>
									<jstlcore:forEach items="${trans}" var="transaction" >
					<tr>
					<td align="center"><jstlcore:out value="${transaction.getCartid()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${transaction.getShiipingname()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${transaction.getCardnumber()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${transaction.getTdate()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${transaction.getTstatus()}"></jstlcore:out></td>
					<td align="center"><jstlcore:out value="${transaction.getProductsnames()}"></jstlcore:out></td>
							</tr>	
									</jstlcore:forEach>	
									
									</table>
							
</body>
</html>