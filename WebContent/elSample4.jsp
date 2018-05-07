<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("One");
	list.add("Two");
	list.add("Three");
	session.setAttribute("word",list);
%>

<%
	String[] a = new String[]{"One","Two","Three"};
	session.setAttribute("data",a);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Array</title>
</head>
<body>

	配列の中身は
	<br>${data[0]}
	<br>${data[1]}
	<br>${data[2]}
	<br>です。
	<br><br>
	ArrayListの中身は
	<br>${word[0]}
	<br>${word[1]}
	<br>${word[2]}
	<br>です。

</body>
</html>