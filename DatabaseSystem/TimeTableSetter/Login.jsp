<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

		<!-- 디자인 파일 로딩 -->
		<link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;amp;lang=en" rel="stylesheet">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" rel="stylesheet">
		<link href="styles/main.css" rel="stylesheet">
		<link rel="stylesheet" href="styles/custom.css">
		<link rel="stylesheet" href="assets/css/style.css">
	<style type="text/css">
		*	{margin: 10px; padding: 10px;}
	</style>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>

//ID, PW Input 필드에 아무것도 입력하지 않았는지 검사하는 함수
function checkValue()
{
    inputForm = eval("document.loginInfo");
    if(!inputForm.stdID.value)
    {
        alert("아이디를 입력하세요");    
        inputForm.stdID.focus();
        return false;
    }
    if(!inputForm.stdPW.value)
    {
        alert("비밀번호를 입력하세요");    
        inputForm.stdPW.focus();
        return false;
    }
}
</script>

</head>
<body>

<!-- 내비게이션 바 -->
			<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			
			<a href="schedule.jsp" id="contact-button" class="mdl-button mdl-button--fab mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast mdl-shadow--4dp">
				<i class="material-icons">event</i>
			</a>    	
			<header class="mdl-layout__header mdl-layout__header--waterfall site-header">
			<div class="mdl-layout__header-row site-logo-row">
				<span class="mdl-layout__title">
				
					<a href="index.jsp"><span class="site-description"><h4 style="color:white;">CBNU TIMETABLE</h4></span></a>
				</span>
			</div>
			<div class="mdl-layout__header-row site-navigation-row mdl-layout--large-screen-only">
				<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
					<a class="mdl-navigation__link" href="SelectCourse.jsp">시간표 관리</a>
				
					<a class="mdl-navigation__link" href="SelectCourse.jsp">내 시간표</a>
					<a class="mdl-navigation__link" href="CheckList.jsp">공학인증 체크리스트</a>
					
					<a class="mdl-navigation__link" href="join.jsp">회원가입</a>

				</nav>
			</div>
		</header>
		
		
		<div class="mdl-layout__drawer mdl-layout--small-screen-only">
			<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
					<a class="mdl-navigation__link" href="SelectCourse.jsp">시간표 관리</a>
				
					<a class="mdl-navigation__link" href="SelectCourse.jsp">내 시간표</a>
					<a class="mdl-navigation__link" href="CheckList.jsp">공학인증 체크리스트</a>
					
					<a class="mdl-navigation__link" href="Login.jsp">로그인</a>

			</nav>
		</div>
		</div>
		<!-- 실제 코드 -->
	<h1 style="text-align:center;">Login</h1>
	<hr>
	<br>
	<div style="text-align:center;">
	<form action="Login.do" method="post" onsubmit="return checkValue()"
		name="loginInfo">
		ID<input type="text" placeholder="ID를 입력하세요" name="stdID" class="stdID"><br>
		PW<input type="password" placeholder="PW를 입력하세요" name="stdPW" class="stdPW"><br>
		<button type="submit" value="Login">로그인</button><br> <a href="join.jsp">회원가입</a>
	</form>
	</div>
	
	<%
	//부득이하게 스크립틀릿 사용
	//ID만 일치하고 PW가 틀릴 경우
	//로그인에 실패했던 ID를 ID Input 필드의  value로 설정헤준다.
		String check = request.getParameter("check");
		if(check != null && check.equals("0")){
			String stdID = request.getParameter("stdID");
			out.println("<script type='text/javascript'>alert('PW를 확인해주세요');</script>");
			out.println("<script>var stdID =" + stdID +"; </script>");
			out.println("<script>$(document).ready(fuinction(){</script>");
			out.println("<script>$('.stdID').val(stdID);</script>");
			out.println("<script>$('.stdPW').focus();</script>");
			out.println("<script>}</script>");
		}
		
		else if(check!=null && check.equals("-1"))
        {    
			out.println("<script type='text/javascript'>alert('ID를 확인해주세요');</script>");
			out.println("<script>$(document).ready(fuinction(){</script>");
			out.println("<script>$('.stdID').focus();</script>");
			out.println("<script>}</script>");
        }
	%>
	
	<!-- 실제 코드 END -->
	
		
		

</body>
</html>