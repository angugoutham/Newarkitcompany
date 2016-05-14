<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select a card</title>
</head>
<body>
Please select a card from a list of cards

<table>
<tbody><tr>
							<td width="90">
							<div id="menu" align="center"><a href="<jstlcore:url value="/viewcustomer.htm"/>">
							customer_Page </a></div>
							</td>							
						</tr>

<tr>
<form method="get" name="cardselectform" action="cardselect.htm">
<jstlcore:forEach items="${registeredcards}" var="registeredcards1" >
<input type="submit" name="selectedcard" value="${registeredcards1.getCcNumber()}" checked><br><br><br>

</jstlcore:forEach>
</form>
</tr>

</table>
<table>
<tr><td colspan="4" align="center"><div style="font-size: 15px; color: red; font-weight: bold;">${CARDSELECTEDSUCESSFULLY}</div></td></tr>
	</tr>
	</table>
</body>
</html>