<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--request.setAttribute("code", "<script>alert('hello')</script>");   使用c标签代替java代码标签--%>
<c:set var="code" value="<script>alert('hello');</script>" scope="request"/>
<c:out value="${code }" escapeXml="true"/><br/>    <%--escapeXml默认值为true,value可以是字符常量，也可以是el表达式 --%>
<c:url value="/Aservlet"/><br/>
${pageContext.request.contextPath }/Aservlet<br/>
<a href="<c:url value='/index.jsp'/>">点击这里回到主页</a>
<br/>
<c:url value="/index.jsp">
	<c:param name="name" value="李四"/>
	</c:url>
	<hr/>
<c:if test="${empty param.name }">
	您没有给出name的参数
</c:if>
<hr/>
<c:choose>
<c:when test="${empty param.name }">
	您没有给出name的参数
</c:when>
<c:otherwise>name参数已经给了${param.name }</c:otherwise>
</c:choose>
<br/>
<c:forEach var="i" begin="1" end="10" step="2">${i }<br/></c:forEach> <%--step默认为1 --%>
<br/>
<%
	String[] strs = {"one","two"};
	request.setAttribute("strs", strs);
%>
<c:forEach items="${strs }" var="str">
	${str }<br/>
</c:forEach>
<hr/>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("4");
	list.add("5");
	list.add("6");
	
	pageContext.setAttribute("list", list);
%>
<c:forEach items="${list }" var="ele" varStatus="vs">
	<%-- ${ele }<br/>--%>
	<%--count 循环元素个数，
	index: 循环元素的下标, 
	first:是否为第一个元素
	last:是否为最后一个元素
	current:当前元素
	  --%>
	${vs.index } ${vs.count } ${vs.first } ${vs.last } ${vs.current }<br/>
</c:forEach>
<hr/>
<%
	Date date = new Date();
	request.setAttribute("d", date);
%>
<fmt:formatDate value="${requestScope.d }" pattern="yyyy-MM-dd HH:mm:ss"/>
<hr/>
<%
	request.setAttribute("num", 3.141592654);
	request.setAttribute("num2", 3.1);
%>
<fmt:formatNumber value="${requestScope.num }" pattern="0.000"></fmt:formatNumber><br>
<fmt:formatNumber value="${requestScope.num2 }" pattern="0.000"></fmt:formatNumber><br>
<fmt:formatNumber value="${requestScope.num2 }" pattern="#.###"></fmt:formatNumber><br><%--相对于0.000，如果位数不足，不补位 --%>
</body>
</html>