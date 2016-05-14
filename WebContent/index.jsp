
<html>
<head>
<title>Welcome to NewarkIT</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-
8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />
<script language="JavaScript">
<!--
var nHist = window.history.length;
if(window.history[nHist] != window.location)
  window.history.forward();
//-->
</script>

<script type="text/javascript">
function validateForm()
{
var uname=document.forms["logForm"]["CustomerName"].value;
var password=document.forms["logForm"]["PASSWORD"].value;
if (uname==null || uname=="")
{
alert("Please provide Username");
return false;
}
if (password==null || password=="")
{
alert("Please provide Password");
return false;
}
}
</script>
</head>
<style>
.error {
	color: red;
	font-size: 13px; 
	font-weight: bold;
}
</style>

<body>
<br/><br/><br/><br/><br/><br/>

<form method="post" name="logForm" action="searchCustomer.htm" 

onsubmit="return validateForm()">
<table width="80%" align="center" border="2" 

bordercolor="#339999">
	<tr>
		<td align="Center">
		<div id="header">&nbsp;
		<div align="center">NEWARK IT

</div>
		</div>
		<!-- header end -->
		<br/>
		<table>
			<tr>
				<!--content begin -->
				<td colspan="2" align="center">
				<div id="content">
				<h3>Portal Login Page</h3>
				</div>
				</td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="CustomerName"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="PASSWORD">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type='submit' value=" Login "></input> <br />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><span class="error">${ERROR}</span></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>
				<div id="content">New Customer:</div>
				<div id="content"><a href="/newarkit/registration.jsp">Register here</a></div>
				
				</td>
			</tr>
		</table>
		<br />
		</td>
	</tr>
</table>

</form>

</body>

</html>
