<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="sht.beans.PlusBean" %>

<%
  	PlusBean bean = (PlusBean)request.getAttribute("plus");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h3>${plus.value1 }+${plus.value2 }=${plus.answer}</h3>

</body>
</html>