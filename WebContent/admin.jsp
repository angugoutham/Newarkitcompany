
<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
Newark IT</title>

 <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script>
$(document).ready(function() {
    $("#datepicker").datepicker();
  });
$(document).ready(function() {
    $("#datepicker1").datepicker();
  });
</script> 

</head>
<body>


			<div align="center">
			<h1>Welcome Admin</h1></div>

			
						<form method="get" action="admincontroller.htm">
			
  Start Date:
  <input type="date" name="StartDate" id="datepicker">
 
  End Date:
  <input type="date" name="EndDate" id="datepicker1">
  <br>
<input type="radio" name="S" value="Frequentlysold" checked>Most frequently sold products.
<br>
<input type="radio" name="S" value="DistinctCustomers">The products which are
sold to the highest number of distinct customers. 
<br>
<input type="radio" name="S" value="Best Customers">10 Best Customers.
<br>
<input type="radio" name="S" value="5 Best Zip">5 Best Zip Codes.
<br>
<input type="radio" name="S" value="Average product price">Average Selling product price.
<br><br>
<input type="submit">
</form>
</body>
</html>