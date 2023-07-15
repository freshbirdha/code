<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>succ2</h1>
<%
	String username = (String)session.getAttribute("username");
	if(username==null){
		request.setAttribute("msg", "您还没有登录");
		request.getRequestDispatcher("/session2/login.jsp").forward(request, response);
		return;		
	}
%>
欢迎<%=username %>
</body>
</html>