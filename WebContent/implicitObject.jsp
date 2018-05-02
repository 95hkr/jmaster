<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String value = request.getParameter("name");
	session.setAttribute("name", value);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Use Implicit Object</title>
</head>
<body>

指定されたパラメータ値は
<%
	value = (String)session.getAttribute("name");
	out.println(value);
%>
です。

</body>
</html>