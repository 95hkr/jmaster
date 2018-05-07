<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setAttribute("data","This is sample1");
	session.setAttribute("data","This is sample2");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Sample</title>
</head>
<body>

<!-- EL式 -->
<h3>data1は${data1}です</h3>
<h3>data2は${data2}です</h3>
<!--  JSPタグ -->>
<h3>data1は<%= request.getAttribute("data1") %>です。</h3>
<h3>data2は<%= session.getAttribute("data2") %>です。</h3>

</body>
</html>