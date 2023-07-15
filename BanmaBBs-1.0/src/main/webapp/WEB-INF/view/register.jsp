<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">

<HTML>
<HEAD>
<TITLE>斑马学员论坛--注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<SCRIPT language=javascript>
	function check() {
		//return true;  //用来测试注册时什么都不填直接点注册，即将这段js判断代码禁掉来判断  或注册时判断两次输入的密码是否一致 
		if (document.regForm.uName.value == "") {
			alert("用户名不能为空");
			return false;
		}
		if (document.regForm.uPass.value == "") {
			alert("密码不能为空");
			return false;
		}
		if (document.regForm.uPass.value != document.regForm.uPass1.value) {
			alert("2次密码不一样");
			return false;
		}
	}
</SCRIPT>

<META name=GENERATOR content="MSHTML 8.00.6001.18783">
</HEAD>
<BODY>

	<!--      用户信息、登录、注册        -->
	<%@ include file="include/head.jsp"%>

	<BR>
	<!--      导航        -->
	<DIV>
		&gt;&gt;<B><A href="http://127.0.0.1:8080/jspbbs/index.jsp">论坛首页</A></B>
	</DIV>
	<!--      用户注册表单        -->
	<DIV style="MARGIN-TOP: 15px" class=t align=center>
		<FORM onsubmit="return check()" method=post name=regForm
			action="register">
			<BR>用&nbsp;户&nbsp;名 &nbsp; <INPUT class=input tabIndex=1
				maxLength=20 size=35 name=uName tryp="text">${message } <BR>密&nbsp;&nbsp;&nbsp;&nbsp;码
			&nbsp; <INPUT class=input tabIndex=2 maxLength=20 size=40
				type=password name=uPass> <BR>重复密码 &nbsp; <INPUT
				class=input tabIndex=3 maxLength=20 size=40 type=password
				name=uPass1> <BR>性别 &nbsp; 女<INPUT value="女" type=radio
				name=gender> 男<INPUT value="男" CHECKED type=radio name=gender>
			<BR>请选择头像 <BR> <IMG src="images/1.gif"><INPUT
				value=1.gif CHECKED type=radio name=head> <IMG
				src="images/2.gif"><INPUT value=2.gif type=radio name=head>
			<IMG src="images/3.gif"><INPUT value=3.gif type=radio name=head>
			<IMG src="images/4.gif"><INPUT value=4.gif type=radio name=head>
			<IMG src="images/5.gif"><INPUT value=5.gif type=radio name=head>
			<BR> <IMG src="images/6.gif"><INPUT value=6.gif type=radio
				name=head> <IMG src="images/7.gif"><INPUT value=7.gif
				type=radio name=head> <IMG src="images/8.gif"><INPUT
				value=8.gif type=radio name=head> <IMG src="images/9.gif"><INPUT
				value=9.gif type=radio name=head> <IMG src="images/10.gif"><INPUT
				value=10.gif type=radio name=head> <BR> <IMG
				src="images/11.gif"><INPUT value=11.gif type=radio name=head>
			<IMG src="images/12.gif"><INPUT value=12.gif type=radio
				name=head> <IMG src="images/13.gif"><INPUT
				value=13.gif type=radio name=head> <IMG src="images/14.gif"><INPUT
				value=14.gif type=radio name=head> <IMG src="images/15.gif"><INPUT
				value=15.gif type=radio name=head> <BR> <INPUT
				class=btn tabIndex=4 value="注 册" type=submit>
		</FORM>
	</DIV>
	<!--      声明        -->

	<%@ include file="include/footer.jsp"%>
</BODY>
</HTML>
