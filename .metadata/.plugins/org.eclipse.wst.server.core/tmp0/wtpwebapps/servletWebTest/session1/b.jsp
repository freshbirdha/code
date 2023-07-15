<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>获取session中的数据</h1>
<%String s = (String)session.getAttribute("aaa"); %>
<%=s %>
</body>
</html>