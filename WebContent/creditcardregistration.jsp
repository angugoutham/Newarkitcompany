<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>NEWARKIT credit card Registration System</title>
 <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script>
$(document).ready(function() {
    $("#datepicker").datepicker();
  });

</script> 
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
	var creditcardnumber=document.forms["regform"]["ccnumber"].value;
	var secnumber=document.forms["regform"]["Sectionnumber"].value;
	var ownerName=document.forms["regform"]["ownername"].value;
	var creditcardtype=document.forms["regform"]["cctype"].value;
	var creditcardAddress=document.forms["regform"]["ccaddress"].value;
	var expdate=document.forms["regform"]["edate"].value;
	
	if (creditcardnumber==null || creditcardnumber=="")
	  {
	  alert("Please provide creditcardnumber");
	  return false;
	  }
	if (secnumber==null || secnumber=="")
	  {
	  alert("Please provide secnumber");
	  return false;
	  }
	if (ownerName==null || ownerName=="")
	  {
	  alert("Please provide ownerName");
	  return false;
	  }
	if (creditcardtype==null || creditcardtype=="")
	  {
	  alert("Please provide creditcardtype");
	  return false;
	  }
	if (creditcardAddress==null || creditcardAddress=="")
	  {
	  alert("Please confirm creditcardAddress");
	  return false;	
	  }
	if (expdate==null || expdate=="")
	  {
	  alert("Please provide expdate");
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
	<form action="newcreditcard.htm" name="regform" method="post" onsubmit="return validateForm()">
	<table width="80%" align="center"  border="2">
		<tbody><tr>
			<td>
			<div id="header">&nbsp;
			<div align="center">Newarkit credit card  Registration System</div>
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
							<h3>Newarkit credit card  Registration System</h3>
							</td>
						</tr>
						<tr><td align="center" colspan="2" style="font-style: italic;">Fields marked (<span style="font-weight: bold;color: red; font-size: 15px;">*</span>) are Mandatory</td></tr>
						<tr><td></td><td></td></tr>
						<tr><td></td><td></td></tr>
						<tr>
						
							<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						Credit cardnumber:</td><td> 
							   <input type="text" name="ccnumber" size="25"></input></td> 
							
					   </tr>
					   <tr>			
							<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
							SecNumber: </td><td><input type="text" name="Sectionnumber" size="25"></input></td>
							
					   </tr>
					   <tr>
							<td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
							owner Name:</td><td><input type="text" name="ownername" size="25"></input></td> 
							
					   </tr>
					   <tr>
						    <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						    credicardtype:</td><td><input type="text" name="cctype" size="27"></input></td>
						   
					   </tr>
					   <tr>
						    <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						     creditcardAddress:</td><td><input type="text" name="ccaddress" size="27"></input></td>
						   
					   </tr>
					   <tr>
						   <td><span style="font-weight: bold;color: red;font-size: 15px;">*</span>
						    Expdate: </td><td> <input type="date" name="edate" id="datepicker"></input><b><br>format should be in YYYY-MM-DD</b></td> 
							
						    
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
		<tr><td colspan="4" align="center"><div style="font-size: 15px; color: red; font-weight: bold;">${CREDITCARDREGISTRATIONSTATUSMESSAGE}</div></td></tr>
	</tbody></table>
	
	</form>
</body>

</html>
