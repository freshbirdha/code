<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>获取cookie</h1>
<%
	Cookie[] cookies=request.getCookies();
	if(cookies !=null){
		for(Cookie c : cookies){
			out.println(c.getName() +"=" + c.getValue());
		}
	}
%>
</body>
</html>