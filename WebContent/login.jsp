<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<form action="/jmaster/AppServlet" method="post">
ユーザ名：<input type="text" name="name"/><br/>
パスワード：<input type="password" name="pw"/><br/>
<input type="hidden" name="action" value="login"/>
<input type="submit" value="ログイン"/>
</form>

<hr/>
アカウント登録

<form action="/jmaster/AppServlet" method="post">
新規ユーザ名：<input type="text" name="newname"/><br/>
新規パスワード：<input type="password" name="newpw"/><br/>
<input type="hidden" name="action" value="add"/>
<input type="submit" value="登録"/>
</form>

</body>
</html>