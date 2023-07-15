<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<DIV>
	<A href="index">
		<IMG src="images/logo.png" width="123px;" height="45px;">
	</A>
	</DIV>
	<!--      用户信息、登录、注册        -->

	<c:choose>	
	 <c:when test="${not empty user }"> 
	 <DIV class=h>您好：${user.username } &nbsp;| &nbsp;<A href="DoExit">登出</A></DIV>	 
	 </c:when>	
	 <c:otherwise>
	 <DIV class=h>
		您尚未 <A href="login">登录</A> &nbsp;|&nbsp; <A href="register">注册</A> |</DIV>
	 </c:otherwise>
	</c:choose>