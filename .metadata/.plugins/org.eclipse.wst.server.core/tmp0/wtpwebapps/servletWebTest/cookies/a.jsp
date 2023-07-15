<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>保存cookie</h1>
<%--request response session application pageContext config out page exception  --%>
<%
	Cookie cookie1 = new Cookie("aaa","AAA");
	response.addCookie(cookie1);
	cookie1.setMaxAge(60*60);
	Cookie cookie2 = new Cookie("bbb","BBB");
	response.addCookie(cookie2);
%>
</body>
</html>