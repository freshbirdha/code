<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>a.jsp</h1>
	  <jsp:forward page="b.jsp">
	     <jsp:param name="username" value="zhangsan"/>
	     <jsp:param name="password" value="123"/>
	  </jsp:forward>
</body>
</html>