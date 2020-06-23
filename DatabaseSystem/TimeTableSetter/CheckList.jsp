<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%@ page import="model.dao.UserListDAO" %>
<%@ page import="model.dto.UserListDTO" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
		
<title>CheckList Page</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<link rel="stylesheet" href="assets/css/style.css">
<script type="text/javascript" src="assets/js/script.js"></script>
<script type="text/javascript" src="assets/js/CheckList.js"></script>
<script type="text/javascript" src="assets/js/SaveList.js"></script>
<script type="text/javascript" src="assets/js/UserList.js"></script>

<!-- 디자인 파일 로딩 -->
		<link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;amp;lang=en" rel="stylesheet">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" rel="stylesheet">
		<link href="styles/main.css" rel="stylesheet">
		<link rel="stylesheet" href="styles/custom.css">

		<style type="text/css">
			*	{margin: 0px; padding: 0px;}
		</style>

</head>
<body style="text-algin:center;">
<!-- 내비게이션 바 -->
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			
				
			<a href="schedule.html" id="contact-button" class="mdl-button mdl-button--fab mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast mdl-shadow--4dp">
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
					

				</nav>
			</div>
		</header>

<div class="mdl-layout__drawer mdl-layout--small-screen-only">
			<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
					<a class="mdl-navigation__link" href=SelectCourse.jsp>시간표 관리</a>
				
					<a class="mdl-navigation__link" href="SelectCourse.jsp">내 시간표</a>
					

			</nav>
		</div>

<div class="mdl-layout__content">
			<div class="site-content">
				<div class="container">
					<br><section class="mdl-grid site-max-width">

<!-- 2018/07/17구경민 코드 START -->
	<div>
	졸업 년도
	<select name="ghGraduateYear" id="ghGraduateYear">
		<option value="">년도 선택</option>
		<option value="2019" >2019</option>
		<option value="2020" >2020</option>
		<option value="2021" >2021</option>
		<option value="2022" >2022</option>
	</select>
	</div>
	
	<button style="width:170px; font-family: inherit; font-size:15px; margin-left:50px; margin-right:30px;"id="showList" type="button" onclick="sendInfo();">전체 목록 보기</button>
	<button style="width:190px; font-family: inherit; font-size:15px; margin-left:50px; margin-right:30px;"id="remainList" type="button" onclick="userlist()" style="">수강한 목록 보기</button>
	</section>
	<hr>
	<br>
	<div class="div-2">
		<p>${stdID}님안녕하세요</p>
		<form action="Logout.do" method="post">
		<button type="submit">로그아웃</button>
		</form>
	</div>
	<div id = "context" style="margin-left:20%; width:60%;">
	<form name="form1">
	<div>
	<h1 style="text-align:center;">교양</h1>
	<table style="width:100%;">
		<thead>
			<tr>
				<th><h1 style="font-size:20px">과목 명</h1></th>
				<th><h1 style="font-size:20px">학점</h1></th>
				<th><h1 style="font-size:20px">설계 학점</h1></th>
				<th><h1 style="font-size:20px">수강 여부</h1></th>
			</tr>
		</thead>
		
		<tbody id="ajaxTable">
		</tbody>
	</table>
	</div>
	</form>
	
	<form name="form2">
	<div>
	<h1 style="text-align:center;">전공 필수</h1>
	<table style="width:100%;">
		<thead>
			<tr>
				<th><h1 style="font-size:20px">과목 명</h1></th>
				<th><h1 style="font-size:20px">학점</h1></th>
				<th><h1 style="font-size:20px">설계 학점</h1></th>
				<th><h1 style="font-size:20px">수강 여부</h1></th>
			</tr>
		</thead>
		
		<tbody id="ajaxTable2">
		</tbody>
	</table>
	</div>
	</form>
	
	<form name="form3">
	<div>
	<h1 style="text-align:center;">전공 선택</h1>
	<table style="width:100%;">
		<thead>
			<tr>
				<th><h1 style="font-size:20px">과목 명</h1></th>
				<th><h1 style="font-size:20px">학점</h1></th>
				<th><h1 style="font-size:20px">설계 학점</h1></th>
				<th><h1 style="font-size:20px">수강 여부</h1></th>
			</tr>
		</thead>
		
		<tbody id="ajaxTable3">
		</tbody>
	</table>
	</div>
	</form>

	<div>
		<button style=" font-size:15px;" type="button" id="save" value="리스트 저장" onclick="CheckBox()">리스트 저장</button>
	</div>
</div><!-- conext END -->	
<!-- 2018/07/17구경민 코드 END -->

<!-- 시간표나 작성하기가기 버튼 -->
					<section class="section--center mdl-grid site-max-width homepage-portfolio">
						<a class="mdl-button mdl-button--raised mdl-js-button mdl-js-ripple-effect mdl-button--accent"
							href="SelectCourse.jsp">시간표 작성하러가기</a>
					</section>
				</div>
			</div>
	</div>
	</div>
</body>
</html>