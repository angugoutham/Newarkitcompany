<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/include.jsp"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form" %>


<%@page import="com.entity.Customer" %>
<%@page import="org.apache.catalina.Session" %><html>
<head>
<title>Welcome newark it comapany  </title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
<script language="JavaScript">
<!--
var nHist = window.history.length;
if(window.history[nHist] != window.location)
  window.history.forward();
//-->
</script>
<script type="text/javascript">
function isNumeric(value) {
	  if (value == null || !value.toString().match(/^[-]?\d*\.?\d*$/))
	  { return false;
	  }
	  return true;
	}
function echeck(str) {
	   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;   
		   return emailPattern.test(str);   							
	}
	function validateForm()
	{
	var fname=document.forms["updateVisitor"]["firstname"].value;
	var lname=document.forms["updateVisitor"]["lastname"].value;
	var email=document.forms["updateVisitor"]["email"].value;
	//var pwd=document.forms["updateVisitor"]["password"].value;
	var phoneno=document.forms["updateVisitor"]["phoneno"].value;
	var address=document.forms["updateVisitor"]["address"].value;
	//var cpwd=document.forms["updateVisitor"]["cpassword"].value;
	
	if (fname==null || fname=="")
	  {
	  alert("Please provide Firstname");
	  return false;
	  }
	if (lname==null || lname=="")
	  {
	  alert("Please provide Lastname");
	  return false;
	  }
	if (email==null || email=="")
	  {
	  alert("Please provide email");
	  return false;
	  }
	
	/* if (pwd==null || pwd=="")
	  {
	  alert("Please provide password");
	  return false;
	  }
	if(pwd!=cpwd)
	{
		alert("Password and confirm password must be same !!");
		return false;
	}*/
	if (phoneno==null || phoneno=="")
	  {
	  alert("Please provide phoneno");
	  return false;
	  }

	if (echeck(email)==false){
		alert("Invalid EmailID");
		return false;
	}
	if(isNumeric(phoneno)==false)
	{
		alert("Invalid Phonenumber");
		return false;
	}
}
	function cancelUpdate()
	{
		alert("Your request to update info has been cancelled");
		//window.location.replace("visitormain.jsp");
		document.forms[0].action = "viewcustomer.htm";
		document.forms[0].submit();
	}
	function displayStatus()
	{
		var updstatus=document.forms["updateVisitor"]["status"].value;
		if(updstatus=="success")
		{
			alert("cusotmer details succesfully updated.. Please Login again..");
			window.location.replace("index.jsp");
		}
	}
</script>
<style type="text/css">
<!--
.style1 {
	font-size: 12
}
-->
</style>
<style>
.error {
	color: red;
}
</style>
</head>

<body onload="displayStatus()">
	
	<%
	Customer customer=(Customer)session.getAttribute("Customer");
	
	%>
	<form method="post" name="updateVisitor" action="updatecustomer.htm" onsubmit="return validateForm()">
	<input type="hidden" name="status" value="${status}">
	<table width="80%" height="100%" border="2" align="center">
		<tr>
			<td>
			

			<table>
				<tr>
					<td width="100%">
					<table align="right" cellpadding="2">
						<tr>
							<td width="90">
							<div id="menu" align="center">
							<a href="<jstlcore:url value="/index.jsp"/>"> Logout </a></div>
							</td>
							<td width="90">
							<div id="menu" align="center"><a
								href="<jstlcore:url value="/viewcustomer.htm"/>"> customer page</a><br />
							</div>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td width="900">
					<div id="style1" align="center">
					<h3>Update your information</h3>
					<br />
					</div>
					<table align="center" border="0">

						<tbody>
							<tr><td align="center" colspan="2" style="font-style: italic;">Fields marked (<span style="font-weight: bold;color: red; font-size: 15px;">*</span>) are Mandatory</td></tr>
						<tr><td></td><td></td></tr>
						<tr><td></td><td></td></tr>
							<tr>
								<td>First Name:</td>
								<td><input type="text" value="<%=customer.getFname()%>" name="firstname" size="25"></input></td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" value="<%=customer.getLname() %>" name="lastname" size="25"></input></td>
							</tr>
							<tr>
								<td>User Name:</td>
								<td><input type="text" value="<%= customer.getUsername() %>" name="username" size="25"></input>
									
								</td>
							</tr>
							
							<tr>
								<td>Email:</td>
								<td><input type="text" value="<%= customer.getAddress() %>" name="email" size="25"></input></td>
							</tr>
							<tr>
								<td>Phone Number:</td>
								<td><input type="text" value="<%= customer.getPhone() %>" name="phoneno" size="25"></input></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><input type="text" name="address" value="<%= customer.getAddress() %>" size="25"></input></td>
							</tr>
							<tr>
								<td>status:</td>
								<td><input type="text" name="status" value="<%= customer.getStatus() %>" size="25"></input></td>
							</tr>
							
							<tr>
								<td colspan="2" align="right"><input value="Cancel" type="Button" onclick="cancelUpdate()">
								<input value="Update" type="submit"></td>
							</tr>
							
						</tbody>
						
					</table>
					</td>
					<!-- content end -->
				</tr>
				<tr>
						<td colspan="2" align="center" style="error">${updatestatus}</td>
						</tr>
			</table>
			</td>
		</tr>
	</table>

</form>
</body>

</html>
