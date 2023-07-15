<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImg(){
		var img = document.getElementById("img");
		img.src = "/servletWebTest/DrawDemoServlet?a=" + new Date().getTime();
	}
</script>
</head>
<body>
<%--本页面提供登录表单 还要提示显示错误信息 --%>
<h1>登录</h1>
<%
/*
读取名为uname的cookie
如果为空显示:""
如果不为空显示:Cookie的值
*/
String uname="";
Cookie[]cs = request.getCookies();
if(cs!=null){
	for(Cookie c : cs){
		if("uname".equals(c.getName())){//查找名为uname的cookie
			uname = c.getValue();//获取cookie的值，给uname这个变量
		}
	}
}
%>

<% 	String message = "";
	String msg=(String)request.getAttribute("msg"); 
	if(msg!=null){
		message = msg;
	}
%>
<font color="red"><b><%=message %></b></font>
<form action="/servletWebTest/LoginServlet" method="post">
	用户名: <input type="text" name="username" value="<%=uname%>"><br/>
	密码:   <input type="password" name="passsword"><br/>
	验证码: <input type="text" name="drawdemocode" size = "3">
		   <img id="img" src="/servletWebTest/DrawDemoServlet">
		   <a href="javascript:changeImg()">换一张</a>
	   <br/>
<input type="submit" value="登录">
</form>
</body>
</html>