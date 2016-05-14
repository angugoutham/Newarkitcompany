<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>NEWARKIT Shipping address details</title>
<script language="JavaScript">
<!--
var nHist = window.history.length;
if(window.history[nHist] != window.location)
  window.history.forward();
//-->
</script>
<script type="text/javascript">
function isNumeric(value) {
	  if (value=="" || value == null || !value.toString().match(/^[-]?\d*\.?\d*$/))
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
	var shippingaddressname=document.forms["regform"]["SAName"].value;
	var RecName=document.forms["regform"]["RecepientName"].value;
	var Street=document.forms["regform"]["street"].value;
	var Streetnumber=document.forms["regform"]["StreetNumber"].value;
	var City=document.forms["regform"]["city"].value;
	var Zip=document.forms["regform"]["zip"].value;
	var State=document.forms["regform"]["state"].value;
	var Country=document.forms["regform"]["country"].value;
	
	if (shippingaddressname==null || shippingaddressname=="")
	  {
	  alert("Please provide shippingaddressname");
	  return false;
	  }
	if (RecName==null || RecName=="")
	  {
	  alert("Please provide RecName");
	  return false;
	  }
	if (Street==null || Street=="")
	  {
	  alert("Please provide Street");
	  return false;
	  }
	if (Streetnumber==null || Streetnumber=="")
	  {
	  alert("Please provide Streetnumber");
	  return false;
	  }
	if (City==null || City=="")
	  {
	  alert("Please provide City");
	  return false;	
	  }
	if (Zip==null || Zip=="")
	  {
	  alert("Please provide Zip");
	  return false;
	  }
	  if (State==null || State=="")
	  {
	  alert("Please provide State");
	  return false;
	  }
	  if (Country==null || Country=="")
	  {
	  alert("Please provide Country");
	  return false;
	  }
}
	function cancelRegistration()
	{
		history.go(-1);
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
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
	font-weight: bold;
	font-size: 20px;
}
</style>
</head>

<body>
	<br/><br/>
	<form action="shippingdetails.htm" name="regform" method="post" onsubmit="return validateForm()">
	<table width="80%" align="center"  border="2">
		<tbody><tr>
			<td>
			<div id="header">&nbsp;
			<div align="center">Newarkit Shipping address details</div>
			</div>
			<table>
				<tbody><tr>
					<td width="100%">
					<table align="right" cellpadding="2">
						<tbody><tr>
							<td width="90">
							<div id="menu" align="center"><a href="<jstlcore:url value="/viewcustomer.htm"/>">
							customer_Page </a></div>
							</td>							
						</tr>
					</tbody></table>
					</td>
				</tr>
				<tr>
					<td width="900">
					<div id="content">
					
					<table align="center" border="0">
						
						<tbody><tr>
							<td align="center" colspan="2">
							<h3>Newarkit Shipping address details</h3>
							</td>
						</tr>
						<tr><td align="center" colspan="2" style="font-style: italic;">Fields marked (<span style="font-weight: bold;color: red; font-size: 15px;">*</span>) are Mandatory</td></tr>
						<tr><td></td><td></td></tr>
						<tr><td></td><td></td></tr>
						<tr>
						
							<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						Shipping Address Name:</td><td> 
							   <input type="text" name="SAName" size="25"></input></td> 
							
					   </tr>
					   <tr>			
							<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
							Recepient Name: </td><td><input type="text" name="RecepientName" size="25"></input></td>
							
					   </tr>
					   <tr>
							<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
							Street:</td><td><input type="text" name="street" size="25"></input></td> 
							
					   </tr>
					   <tr>
						    <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						    Street Number:</td><td><input type="text" name="StreetNumber" size="27"></input></td>
						   
					   </tr>
					   <tr>
						    <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						     City:</td><td><input type="text" name="city" size="27"></input></td>
						   
					   </tr>
					   <tr>
						   <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						    Zip: </td><td> <input type="text" name="zip" size="25"></input></td> 
							
						    
					   </tr>
					    <tr>
						    <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						    State:</td><td><input type="text" name="state" size="27"></input></td>
						   
					   </tr>
					   <tr>
						    <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						    Country:</td><td><input type="text" name="country" size="27"></input></td>
						   
					   </tr>
						<tr>	
						   <td colspan="2" align="right">										
						    <input value="Register" type="submit">
						    <input value="Clear" type="reset" ></td>
						</tr>
						<tr>
		
			</tr>
					</tbody></table>
					
					</div>
					</td>
					<!-- content end -->
				</tr>
			</tbody>
			</table>
			</td>			
		</tr>
		<tr><td colspan="4" align="center"><div style="font-size: 15px; color: red; font-weight: bold;">${SHIPPINGDETAILSSTATUSMESSAGE}</div></td></tr>
	</tbody></table>
	
	</form>
</body>

</html>
