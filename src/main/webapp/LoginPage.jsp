<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="./DatabaseServlet" method="post">
UserName : <input type = "text" name="username">
Password : <input type ="password" name="password">
<button type="submit">Login</button>
</form>
</body>
</html>