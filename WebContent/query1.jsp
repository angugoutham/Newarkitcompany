<%@ include file="/include.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="width:10%">
<tr>
<th>pid</th>
<th>pname</th>
<th>total sold</th>
</tr>



<jstlcore:forEach items="${value}" var="value" >
<tr>
<th><jstlcore:out value="${value.getPid()}"></jstlcore:out></th>
<th><jstlcore:out value="${value.getPnmae()}"></jstlcore:out></th>
<th><jstlcore:out value="${value.getSum()}"></jstlcore:out></th>

</tr>
</jstlcore:forEach>

</table>
</body>
</html>