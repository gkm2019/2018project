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
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="assets/js/d3.v3.min.js"></script>
<script>
	function SelectSection() {
		var state = jQuery('#cSection option:selected').val();
		if (state == '전공') {
			jQuery('.cDepartment').show();
			jQuery('.general').hide();
		} else if (state == '교양') {
			jQuery('.cDepartment').hide();
			jQuery('.general').show();
		} else {
			jQuery('.cDepartment').hide();
			jQuery('.general').hide();
		}
	}

	function SelectDiv() {
		var state = jQuery('#cDiv option:selected').val();
		if (state == '공통기초') {
			jQuery('.default').hide();
			jQuery('.common').show();
			jQuery('.science').hide();
			jQuery('.advanced').hide();
			jQuery('.character').hide();
		} else if (state == '자연·이공계 기초') {
			jQuery('.default').hide();
			jQuery('.common').hide();
			jQuery('.science').show();
			jQuery('.advanced').hide();
			jQuery('.character').hide();
		} else if (state == '심화교양') {
			jQuery('.default').hide();
			jQuery('.common').hide();
			jQuery('.science').hide();
			jQuery('.advanced').show();
			jQuery('.character').hide();
		} else if (state == '특성교양') {
			jQuery('.default').hide();
			jQuery('.common').hide();
			jQuery('.science').hide();
			jQuery('.advanced').hide();
			jQuery('.character').show();
		} else {
			jQuery('.default').show();
			jQuery('.common').hide();
			jQuery('.science').hide();
			jQuery('.science').hide();
			jQuery('.character').hide();
		}
	}


	function InsertCart() {
		return confirm("해당 수업을 장바구니에 추가하시겠습니까?");
	}

	function DeleteCart() {
		return confirm("해당 수업을  장바구니에서 삭제하시겠습니까?");
	}
</script>
<style>
body{
background:#F2F2F2;
}
button {
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:40px;
/*   font-size:1.6em; */
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}

 button:before,btn1.button:after{ 
   content:''; 
   position:absolute; 
   top:0; 
   right:0; 
   height:2px; 
   width:0; 
   background: #1AAB8A; 
   transition:400ms ease all; 
 } 
.button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}
td {
	border: 1px #DDD solid;
	padding: 5px;
	cursor: pointer;
}

.selected {
	background-color: #9DC8C8;
	color: #FFF;
}

.cartselected {
	background-color: #58C9B9;
	color: #FFF;
}

.tablesetselected {
	background-color: #519D9E;
	color: #FFF;
}

.mytablesetselected {
	background-color: #D1B6E1;
	color: #FFF;
}

.cDepartment {
	display: none;
}

.general {
	display: none;
}

.common {
	display: none;
}

.science {
	display: none;
}

.advanced {
	display: none;
}

.character {
	display: none;
}

.timetable {
	width: 150px;
	height: 100px;
	border: 1px solid gray;
	display: table-cell;
	text-align: center;
	text-size: 15px;
	position: absolute;
	
}

.ttcell{
	color: #FFF;
}

.div-1 {
	display: inline-block;
	float: left;
}

.div-2 {
	display: block;
}

#selectcoursediv {
	display: inline-block;
	margin-left:920px;
	margin-top:30px;
}

#timetablesetterdiv {
	display: inline-block;	
	margin-left:920px;
	margin-top:50px;
}

.centerr {
text-align:center;
}

.btn1 {
	display:inline-block;
	float:right;
	width:400px;
}

select{
   -webkit-appearance: button;
   -webkit-border-radius: 2px;
   -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
   -webkit-padding-end: 20px;
   -webkit-padding-start: 2px;
   -webkit-user-select: none;
   background-image: url(http://i62.tinypic.com/15xvbd5.png), -webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
   background-position: 97% center;
   background-repeat: no-repeat;
   border: 1px solid #AAA;
   color: #555;
   font-size: inherit;
   margin: 10px;
   overflow: hidden;
   padding: 5px 10px;
   text-overflow: ellipsis;
   white-space: nowrap;
   width: 300px;
}

input#cName {
	 -webkit-appearance: button;
   -webkit-border-radius: 2px;
   -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
   -webkit-padding-end: 20px;
   -webkit-padding-start: 2px;
   -webkit-user-select: none;
   border: 1px solid #AAA;
   color: #555;
   font-size: inherit;
   margin: 10px;
   overflow: hidden;
   padding: 5px 10px;
   text-overflow: ellipsis;
   white-space: nowrap;
   width: 510px;
   height: 30px;
}

p {
	font-weight: bold;
}
</style>
<title>Select Course</title>
</head>
<body onload="Load()">

	<div class="div-1" style="height: 910px; overflow: auto">

		<script>
		function Load(){
			jQuery('#timetablesetterdiv').hide();
			jQuery('#selectcoursediv').show();
			getCartfunction();
			getMyTimeTableSetFunction();
		}
		
		
		$(document).ready(function() {
			LoadTable()
		});
		
		
			
			function ClearTable() {
				for (var i = 1; i <= 5; i++) {
					for (var j = 1; j <= 14; j++) {
						d3.select("#t-" + i + "-" + j).html("");
						d3.select("#t-" + i + "-" + j).style("background-color","");
						d3.select("#t-" + i + "-" + j).style("height", 100);
						d3.select("#t-" + i + "-" + j).style("z-index",0);

					}
				}
			}

			function LoadTable() {
				for (var i = 0; i <= 5; i++) {
					for (var j = 0; j <= 14; j++) {
						$("#t-" + i + "-" + j).css("top",80+ j * 100);
						$("#t-" + i + "-" + j).css("left",i * 150);

					}
				}
			}
			
		</script>


		<div>
			<div>
				<div class="timetable" id="t-0-0"></div>
				<div class="timetable" id="t-1-0">월</div>
				<div class="timetable" id="t-2-0">화</div>
				<div class="timetable" id="t-3-0">수</div>
				<div class="timetable" id="t-4-0">목</div>
				<div class="timetable" id="t-5-0">금</div>
			</div>

			<div>
				<div class="timetable" id="t-0-1">9</div>
				<div class="timetable ttcell" class="tablecell" id="t-1-1"></div>
				<div class="timetable ttcell" class="tablecell" id="t-2-1"></div>
				<div class="timetable ttcell" class="tablecell" id="t-3-1"></div>
				<div class="timetable ttcell" class="tablecell" id="t-4-1"></div>
				<div class="timetable ttcell" class="tablecell" id="t-5-1"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-2">10</div>
				<div class="timetable ttcell" id="t-1-2"></div>
				<div class="timetable ttcell" id="t-2-2"></div>
				<div class="timetable ttcell" id="t-3-2"></div>
				<div class="timetable ttcell" id="t-4-2"></div>
				<div class="timetable ttcell" id="t-5-2"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-3">11</div>
				<div class="timetable ttcell" id="t-1-3"></div>
				<div class="timetable ttcell" id="t-2-3"></div>
				<div class="timetable ttcell" id="t-3-3"></div>
				<div class="timetable ttcell" id="t-4-3"></div>
				<div class="timetable ttcell" id="t-5-3"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-4">12</div>
				<div class="timetable ttcell" id="t-1-4"></div>
				<div class="timetable ttcell" id="t-2-4"></div>
				<div class="timetable ttcell" id="t-3-4"></div>
				<div class="timetable ttcell" id="t-4-4"></div>
				<div class="timetable ttcell" id="t-5-4"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-5">1</div>
				<div class="timetable ttcell" id="t-1-5"></div>
				<div class="timetable ttcell" id="t-2-5"></div>
				<div class="timetable ttcell" id="t-3-5"></div>
				<div class="timetable ttcell" id="t-4-5"></div>
				<div class="timetable ttcell" id="t-5-5"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-6">2</div>
				<div class="timetable ttcell" id="t-1-6"></div>
				<div class="timetable ttcell" id="t-2-6"></div>
				<div class="timetable ttcell" id="t-3-6"></div>
				<div class="timetable ttcell" id="t-4-6"></div>
				<div class="timetable ttcell" id="t-5-6"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-7">3</div>
				<div class="timetable ttcell" id="t-1-7"></div>
				<div class="timetable ttcell" id="t-2-7"></div>
				<div class="timetable ttcell" id="t-3-7"></div>
				<div class="timetable ttcell" id="t-4-7"></div>
				<div class="timetable ttcell" id="t-5-7"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-8">4</div>
				<div class="timetable ttcell" id="t-1-8"></div>
				<div class="timetable ttcell" id="t-2-8"></div>
				<div class="timetable ttcell" id="t-3-8"></div>
				<div class="timetable ttcell" id="t-4-8"></div>
				<div class="timetable ttcell" id="t-5-8"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-9">5</div>
				<div class="timetable ttcell" id="t-1-9"></div>
				<div class="timetable ttcell" id="t-2-9"></div>
				<div class="timetable ttcell" id="t-3-9"></div>
				<div class="timetable ttcell" id="t-4-9"></div>
				<div class="timetable ttcell" id="t-5-9"></div>
			</div>

			<div>
				<div class="timetable" id="t-0-10">6</div>
				<div class="timetable ttcell" id="t-1-10"></div>
				<div class="timetable ttcell" id="t-2-10"></div>
				<div class="timetable ttcell" id="t-3-10"></div>
				<div class="timetable ttcell" id="t-4-10"></div>
				<div class="timetable ttcell" id="t-5-10"></div>
			</div>
			<div>
				<div class="timetable" id="t-0-11">7</div>
				<div class="timetable ttcell" id="t-1-11"></div>
				<div class="timetable ttcell" id="t-2-11"></div>
				<div class="timetable ttcell" id="t-3-11"></div>
				<div class="timetable ttcell" id="t-4-11"></div>
				<div class="timetable ttcell" id="t-5-11"></div>
			</div>
			<div>
				<div class="timetable" id="t-0-12">8</div>
				<div class="timetable ttcell" id="t-1-12"></div>
				<div class="timetable ttcell" id="t-2-12"></div>
				<div class="timetable ttcell" id="t-3-12"></div>
				<div class="timetable ttcell" id="t-4-12"></div>
				<div class="timetable ttcell" id="t-5-12"></div>
			</div>
			<div>
				<div class="timetable" id="t-0-13">9</div>
				<div class="timetable ttcell" id="t-1-13"></div>
				<div class="timetable ttcell" id="t-2-13"></div>
				<div class="timetable ttcell" id="t-3-13"></div>
				<div class="timetable ttcell" id="t-4-13"></div>
				<div class="timetable ttcell" id="t-5-13"></div>
			</div>
			<div>
				<div class="timetable" id="t-0-14">14</div>
				<div class="timetable ttcell" id="t-1-14"></div>
				<div class="timetable ttcell" id="t-2-14"></div>
				<div class="timetable ttcell" id="t-3-14"></div>
				<div class="timetable ttcell" id="t-4-14"></div>
				<div class="timetable ttcell" id="t-5-14"></div>
			</div>
		</div>
	</div>
	
	<div class="div-2">	
		${stdID} 님안녕하세요
		<form action="Logout.do" method="post" class="btn1">
		<button type="submit" style="font-size:15px;" class="btn1">로그아웃</button>
		</form>
		<form action="CheckList.do" method="post" class="btn1">
		<button type="submit" style="font-size:15px;" class="btn1">공학인증 체크리스트 보러가기</button>
		</form>
		<button type = "button" style="font-size:15px;"" class="btn1" onclick="test_show_and_hide();">시간표 생성하기</button>
		<button type = "button" style="font-size:15px;"" class="btn1" onclick="test_show_and_hide2();">수업 선택하기</button>
		
	</div>
	
	
	<div  id="selectcoursediv" class="div-3">
		<div class="centerr">
			<!-- 학점  -->
			<select name="cCredit" id="cCredit">
				<option value="">학점</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>

			<!-- 전공/교양 구분  -->
			<select name="cSection" id="cSection" onchange="SelectSection()">
				<option value="">구분</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
			</select>

			<!-- 전공 선택시 학과 선택 -->
			<div class="cDepartment" >
				<select name="cDepartment" id="cDepartment">
					<option value="">학과</option>
					<option value="소프트웨어">소프트웨어</option>
					<option value="전자">전자</option>
					<option value="전기">전기</option>
					<option value="정보통신">정보통신</option>
				</select>
				<!-- 전공 선택 시 학년 선택  -->
				<select name="cGrade" id="cGrade">
					<option value="">학년</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>

			</div>

			<!-- 교양 선택 시 구분 선택  -->
			<div class="general">
				<select name="cDiv" id="cDiv" onchange="SelectDiv()">
					<option value="">영역구분선택</option>
					<option value="공통기초">공통기초</option>
					<option value="자연·이공계 기초">자연·이공계 기초</option>
					<option value="심화교양">심화교양</option>
					<option value="특성교양">특성교양</option>
				</select>
				
				<!-- 구분 선택 전 세부영역구분  -->
					<select name="cSubDiv" id="cSubDiv">
						<option  value="">세부영역구분선택</option>
						<option class="common" value="국어와작문">국어와작문</option>
						<option class="common" value="외국어">외국어</option>
						<option class="common" value="글쓰기와소통">글쓰기와소통</option>
						<option class="common" value="컴퓨터와활용">컴퓨터와활용</option>
						<option class="science" value="수학">수학</option>
						<option class="science" value="기초과학">기초과학</option>
						<option class="advanced" value="문학과문화">문학과문화</option>
						<option class="advanced" value="역사와철학">역사와철학</option>
						<option class="advanced" value="인간과사회">인간과사회</option>
						<option class="advanced" value="자연과생명">자연과생명</option>
						<option class="advanced" value="기술과문명">기술과문명</option>
						<option class="advanced" value="예술과체육">예술과체육</option>
						<option class="character" value="개신중점강좌">개신중점강좌</option>
						<option class="character" value="지역사회·문화">지역사회·문화</option>
						<option class="character" value="진로와선택">진로와선택</option>
						<option class="character" value="실용외국어">실용외국어</option>
						<option class="character" value="여가와취미">여가와취미</option>
					</select>


				<!-- 특성교양 구분 선택 시 세부영역구분  -->
				<div class="character">
					<select name="cSubDiv">
						<option value="">세부영역구분선택</option>
						<option class="character" value="개신중점강좌">개신중점강좌</option>
						<option class="character" value="지역사회·문화">지역사회·문화</option>
						<option class="character" value="진로와선택">진로와선택</option>
						<option class="character" value="실용외국어">실용외국어</option>
						<option class="character" value="여가와취미">여가와취미</option>
					</select>
				</div>
			</div><br>
			<!-- 검색어 -->
			<input type="text" name="cName" id="cName" placeholder="수업 이름을 검색하세요">
			<button type="button" style="font-size:15px;" onclick="getSearchCoursefunction()">검색</button>


		<h2>검색 결과</h2>
		<div style="height: 300px; overflow: auto">
			<table id="coursetable" class="display">
				<thead>
					<tr>
						<td>번호</td>
						<td>수업 번호</td>
						<td>수업 이름</td>
						<td>교수</td>
						<td>강의시간</td>
						<td>학점</td>
						<td>설계학점</td>
						<td>학과</td>
						<td>구분</td>
						<td>상세구분</td>
						<td>정원</td>
					</tr>
				</thead>
				<tbody id="ctable">
				</tbody>
		
			</table>
		</div>

		<h2>장바구니</h2>
		<div style="height: 300px; overflow: auto" >
			<table id="carttable" class="display">
			<thead>
				<tr>
					<td>번호</td>
					<td>수업 번호</td>
					<td>수업 이름</td>
					<td>교수</td>
					<td>강의시간</td>
					<td>학점</td>
					<td>설계학점</td>
					<td>학과</td>
					<td>구분</td>
					<td>상세구분</td>
					<td>정원</td>
					<td>필수</td>
				</tr>
				</thead>
				<tbody id="ajaxtable">
				</tbody>
			</table>
		</div>
		</div>
	</div>
	
	<div id="timetablesetterdiv">
	<div class="centerr">
		<br>
		<!-- 학점  -->
		<select name="creditlow" id="creditlow">
				<option value="">최소 학점</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
			</select>
			
			<!-- 학점  -->
			<select name="creditupp" id="creditupp">
				<option value="">최대 학점</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
			</select> <br>
			
			<!-- 학점  -->
			<select name="numOfday" id="numOfday">
				<option value="">수업 일수</option>
				<option value="1">주 1일 수업</option>
				<option value="2">주 2일 수업</option>
				<option value="3">주 3일 수업</option>
				<option value="4">주 4일 수업</option>
				<option value="5">주 5일 수업</option>
			</select>
			
			<!-- 학점  -->
			<select name="minclassnum" id="minclassnum">
				<option value="">최소 수업 개수</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select><br>
		
		<button style="font-size:13px;" onclick="getTimeTableSetFunction();">시간표 생성</button>
		<h2>생성된 시간표</h2>
		<div style="height: 300px; overflow: auto" >
			<table class="display">
			<thead>
				<tr>
					<td>번호</td>
					<td>학점</td>
					<td>수업 일수</td>
					<td>수업 개수</td>
				</tr>
				</thead>
				<tbody id="timetablesettable">
				</tbody>
			</table>
		</div>
		
		
		<h2>시간표 장바구니</h2>
		<div style="height: 300px; overflow: auto" >
			<table class="display">
			<thead>
				<tr>
					<td>번호</td>
					<td>학점</td>
					<td>수업 일수</td>
					<td>수업 개수</td>
				</tr>
				</thead>
				<tbody id="mytimetablesettable">
				</tbody>
			</table>
		</div>
	</div>
	</div>
</body>

<script>
/**************************************************************/
/******생성된 시간표 목록 불러오기******************************************/
/**************************************************************/
var TimeTableSetRequest = new XMLHttpRequest();
function getTimeTableSetFunction(){
	var aaa = d3.selectAll(".essential");
	
	var object = eval('(' + request.responseText + ')');
	var result = object.result;
	
	var essentialList = "";
	$("input[name=checktest]:checked").each(function() {
		for(var i=0;i<result.length;i++){
			if(result[i][1].value == $(this).val()){
				if(essentialList == "")
					essentialList += result[i][1].value;
				else
					essentialList += "," + result[i][1].value;
			}
		}
	});
	
		TimeTableSetRequest.open("Post","./GetTimeTableSetServlet?creditlow="+ encodeURIComponent( document.getElementById("creditlow").value )
				+ "&creditupp=" + encodeURIComponent( document.getElementById("creditupp").value)
				+ "&numOfday=" + encodeURIComponent( document.getElementById("numOfday").value)
				+ "&minclassnum=" + encodeURIComponent( document.getElementById("minclassnum").value)
				+ "&essentialList=" + encodeURIComponent( essentialList )
				, true);
	TimeTableSetRequest.onreadystatechange = getTimeTableSetProcess;
	TimeTableSetRequest.send(null);
}

function getTimeTableSetProcess(){
	var table = document.getElementById("timetablesettable");
	table.innerHTML = "";
	if(TimeTableSetRequest.readyState = 4 && TimeTableSetRequest.status == 200){
		var object = eval('(' + TimeTableSetRequest.responseText + ')');
		var result = object.result;
		
		
		var d3test = d3.select("#timetablesettable")
		.selectAll("tr")
		.data(result)
		.enter()
		.append("tr")
		.attr("id",function(d,i){return "tableset-"+i})
		.on("click",tablesetchange);
		
		for(var i=0; i<result.length; i++){
			d3.select("#tableset-"+i)
			.selectAll("td")
			.data(result[i])
			.enter()
			.append("td")
				.text(function(d){
					return d.value;});
			
			d3.select("#tableset-"+i)
			.append("td")
			.append("button")
			.on("click",InsertTimeTable)
			.text("추가");
		}
		
		$(document).ready(function() {
			$("#timetablesettable tr").on('click',function() {
				$(this).addClass('tablesetselected').siblings().removeClass('tablesetselected');
			});
		});
	}
}

function tablesetchange(d,i){
	d3.selectAll(".tablesetselected")
	.attr("class","");
	
	var selectedcart = d3.select("#tableset-"+d[0].value-1);
	selectedcart.attr("class","tablesetselected");
	
	var object = eval('(' + request.responseText + ')');
	var result = object.result;
	
	ClearTable();
	
	var Selected_Course_Time;
	var Selected_Course_ID;
	var Selected_Course_Name;
	var Selected_Course_Professor;
	var Selected_Course_Time_Array;
	
	for(var i=4;i<d.length;i++){
		for(var j=0;j<result.length;j++)
			if(d[i].value == result[j][1].value){
				Selected_Course_Time = result[j][4].value;
				Selected_Course_ID = result[j][1].value;
				Selected_Course_Name = result[j][2].value;
				Selected_Course_Professor = result[j][3].value;
						
				Selected_Course_Time_Array = Selected_Course_Time.split(']');
						
				for (var k = 0; k < Selected_Course_Time_Array.length - 1; k++) {
						var Time_Array = Selected_Course_Time_Array[k].split('[');
						var cRoom = Time_Array[1];
						var day = Time_Array[0].substring(0, 1);
						var time = Time_Array[0].split(',');
						var cTime = time[0].substring(1);
						var height = 100 * time.length;
						
						UpdateTable(Time_Array, cRoom, day, time, cTime, height, Selected_Course_ID, Selected_Course_Name, Selected_Course_Professor, "#519D9E");			
						}
				}		
		}
	}


/**************************************************************/
/****** 시간표 장바구니 목록 불러오기 ************************************/
/**************************************************************/
var MyTimeTableSetRequest = new XMLHttpRequest();
function getMyTimeTableSetFunction(){
	MyTimeTableSetRequest.open("Post","./TimeTableSetListServlet", true);
	MyTimeTableSetRequest.onreadystatechange = getMyTimeTableSetProcess;
	MyTimeTableSetRequest.send(null);
}

function getMyTimeTableSetProcess(){
	var table = document.getElementById("mytimetablesettable");
	table.innerHTML = "";
	if(MyTimeTableSetRequest.readyState = 4 && MyTimeTableSetRequest.status == 200){
		var object = eval('(' + MyTimeTableSetRequest.responseText + ')');
		var result = object.result;
		
		var d3test = d3.select("#mytimetablesettable")
		.selectAll("tr")
		.data(result)
		.enter()
		.append("tr")
		.attr("id",function(d,i){return "mytableset-"+i})
		.on("click",mytablesetchange);
		
		for(var i=0; i<result.length; i++){
			d3.select("#mytableset-"+i)
			.selectAll("td")
			.data(result[i])
			.enter()
			.append("td")
				.text(function(d){
					return d.value;});
			
			d3.select("#mytableset-"+i)
			.append("td")
			.append("button")
			.on("click", DeleteTimeTable) //만들어야됨
			.text("삭제");
		}
		
		$(document).ready(function() {
			$("#mytimetablesettable tr").on('click',function() {
				$(this).addClass('mytablesetselected').siblings().removeClass('mytablesetselected');
			});
		});
	}
}

function mytablesetchange(d,i){
	d3.selectAll(".mytablesetselected")
	.attr("class","");
	
	var selectedcart = d3.select("#mytableset-"+d[0].value-1);
	selectedcart.attr("class","mytablesetselected");
	
	var object = eval('(' + request.responseText + ')');
	var result = object.result;
	
	ClearTable();
	
	var Selected_Course_Time;
	var Selected_Course_ID;
	var Selected_Course_Name;
	var Selected_Course_Professor;
	var Selected_Course_Time_Array;
	
	for(var i=4;i<d.length;i++){
		for(var j=0;j<result.length;j++)
			if(d[i].value == result[j][1].value){
				Selected_Course_Time = result[j][4].value;
				Selected_Course_ID = result[j][1].value;
				Selected_Course_Name = result[j][2].value;
				Selected_Course_Professor = result[j][3].value;
						
				Selected_Course_Time_Array = Selected_Course_Time.split(']');
						
				for (var k = 0; k < Selected_Course_Time_Array.length - 1; k++) {
						var Time_Array = Selected_Course_Time_Array[k].split('[');
						var cRoom = Time_Array[1];
						var day = Time_Array[0].substring(0, 1);
						var time = Time_Array[0].split(',');
						var cTime = time[0].substring(1);
						var height = 100 * time.length;
						
						UpdateTable(Time_Array, cRoom, day, time, cTime, height, Selected_Course_ID, Selected_Course_Name, Selected_Course_Professor, "#D1B6E1");			
						}
				}		
		}
	}

/*****************************************************************/
/************ 시간표 장바구니 추가 ***************************************/
/*****************************************************************/

var InsertTimeTableRequest = new XMLHttpRequest();
function InsertTimeTable(d){
		var creditSum = d[1].value;
		var numOfDay = d[2].value;
		var cList = d[4].value;
		
		for(var i=5; i<d.length; i++){
			cList += "," + d[i].value;
		}
		console.log(creditSum + " " + numOfDay + " " + cList);
			InsertTimeTableRequest.open("Post","./InsertTimeTableServlet?cList=" + encodeURIComponent(cList)
					+ "&creditSum=" + encodeURIComponent(creditSum)
					+ "&numOfDay=" + encodeURIComponent(numOfDay)
					, true);
			InsertTimeTableRequest.onreadystatechange = InsertTimeTableProcess;
			InsertTimeTableRequest.send(null);
}

function InsertTimeTableProcess(){
	if(InsertTimeTableRequest.readyState = 4 && InsertTimeTableRequest.status == 200){
		InsertResult = InsertCartProcess.responseText;
		console.log(InsertResult);
		if(InsertTimeTableRequest == 1){
			alert("장바구니에 추가되었습니다.");
		}
		else if(InsertTimeTableRequest == 0){
			alert("장바구니에 이미 존재하는 수업입니다.");
		}
		else if(InsertTimeTableRequest == -1){
			alert("세션이 만료되어 로그아웃되었습니다.");
		}
	
		getMyTimeTableSetFunction();
	}
}

/*****************************************************************/
/************ 시간표 장바구니 삭제 *******************************************/
/*****************************************************************/
var DeleteTimeTableRequest = new XMLHttpRequest();
function DeleteTimeTable(d){				
		tID = d[0].value;
		DeleteTimeTableRequest.open("Post","./DeleteTimeTableServlet?tID="+ encodeURIComponent(tID), true);
		DeleteTimeTableRequest.onreadystatechange = DeleteTimeTableProcess;
		DeleteTimeTableRequest.send(null);
}

function DeleteTimeTableProcess(){
	if(DeleteTimeTableRequest.readyState = 4 && DeleteTimeTableRequest.status == 200){
		result = DeleteTimeTableRequest.responseText;
		if(result == 1){
			alert("장바구니에서 삭제되었습니다.");
		}
		else if(result == -1){
			alert("세션이 만료되어 로그아웃되었습니다.");
		}
	
		getMyTimeTableSetFunction();
	}
}



		
		
		

		
		/**************************************************************/
		/****** 화면 전환 *************************************************/
		/**************************************************************/
		function test_show_and_hide(){
			jQuery('#timetablesetterdiv').show();
			jQuery('#selectcoursediv').hide();
		}
		
		function test_show_and_hide2(){
			jQuery('#timetablesetterdiv').hide();
			jQuery('#selectcoursediv').show();
		}
		
		/**************************************************************/
		/******장바구니 목록 불러오기******************************************/
		/**************************************************************/
		var request = new XMLHttpRequest();
		function getCartfunction(){
			request.open("Post","./CourseCartListServlet", true);
			request.onreadystatechange = cartlistProcess;
			request.send(null);
		}
	
		function cartlistProcess(){
			var table = document.getElementById("ajaxtable");
			table.innerHTML = "";
			if(request.readyState = 4 && request.status == 200){
				var object = eval('(' + request.responseText + ')');
				var result = object.result;
				
				var d3test = d3.select("#ajaxtable")
				.selectAll("tr")
				.data(result)
				.enter()
				.append("tr")
				.attr("id",function(d,i){return "test-"+i})
				.on("click",changetest);
				
				
				for(var i=0; i<result.length; i++){
					d3.select("#test-"+i)
					.selectAll("td")
					.data(result[i])
					.enter()
					.append("td")
 					.text(function(d){return d.value;});
					
					d3.select("#test-"+i)
					.append("td")
					.append("input")
					.attr("type","checkbox")
					.attr("onclick","onClickHandler()")
					.attr("id","essential-" + function(d,i){return i})
					.attr("value",function(d,i){return d[1].value;})
					.attr("name","checktest");					
					
					d3.select("#test-"+i)
					.append("td")
					.append("button")
					.on("click",DeleteCartfunction)
					.text("삭제");
				}
				
				$(document).ready(function() {
					$("#ajaxtable tr").on('click',function() {
						$(this).addClass('cartselected').siblings().removeClass('cartselected');
					});
				});
			}
		}
		
		function onClickHandler(){
// 			console.log("ddd");
		}
		
		function changetest(d,i){
			d3.selectAll(".cartselected")
			.attr("class","");
			
			var selectedcart = d3.select(".test-"+d[0].value-1);
			selectedcart.attr("class","cartselected");
		
			var Selected_Course_Time = d[4].value;
			var Selected_Course_ID = d[1].value;
			var Selected_Course_Name = d[2].value;
			var Selected_Course_Professor = d[3].value;
			
			ClearTable();
			var Selected_Course_Time_Array = Selected_Course_Time.split(']');
			for (var i = 0; i < Selected_Course_Time_Array.length - 1; i++) {
				var Time_Array = Selected_Course_Time_Array[i].split('[');
				var cRoom = Time_Array[1];
				var day = Time_Array[0].substring(0, 1);
				var time = Time_Array[0].split(',');
				var cTime = time[0].substring(1);
				var height = 100 * time.length;

				UpdateTable(Time_Array, cRoom, day, time, cTime, height, Selected_Course_ID, Selected_Course_Name, Selected_Course_Professor, "#58C9B9");
				}
		}
		
		/******************************************************************/
		/***************** 수업 선택 시 테이블에 표시 *******************************/
		/******************************************************************/
		
		function UpdateTable(Time_Array, cRoom, day, time, cTime, height, Selected_Course_ID, Selected_Course_Name, Selected_Course_Professor, color){
			if (day == "월"){
				d3.select("#t-1-"+cTime).html("<p>"+Selected_Course_Name+"</p>"+Selected_Course_Professor+"<br>"+cRoom)
				.style("background-color",color)
				.style("z-index","1");
				$("#t-1-"+cTime).css("height",height);
				}

			else if (day == "화"){
				d3.select("#t-2-"+cTime).html("<p>"+Selected_Course_Name+"</p>"+Selected_Course_Professor+"<br>"+cRoom)
				.style("background-color",color)
				.style("z-index","1");
				$("#t-2-"+cTime).css("height",height);
				}
			
			else if (day == "수"){
				d3.select("#t-3-"+cTime).html("<p>"+Selected_Course_Name+"</p>"+Selected_Course_Professor+"<br>"+cRoom)
				.style("background-color",color)
				.style("z-index","1");
				$("#t-3-"+cTime).css("height",height);
				}

			else if (day == "목"){
				d3.select("#t-4-"+cTime).html("<p>"+Selected_Course_Name+"</p>"+Selected_Course_Professor+"<br>"+cRoom)
				.style("background-color",color)
				.style("z-index","1");
				$("#t-4-"+cTime).css("height",height);
				}

			else if (day == "금"){
				d3.select("#t-5-"+cTime).html("<p>"+Selected_Course_Name+"</p>"+Selected_Course_Professor+"<br>"+cRoom)
				.style("background-color",color)
				.style("z-index","1");
				$("#t-5-"+cTime).css("height",height);
				}
		}
		
		/******************************************************************/
		/***************** 수업 검색 ******************************************/
		/******************************************************************/
		var SearchRequest = new XMLHttpRequest();
		function getSearchCoursefunction(){
			
			SearchRequest.open("Post","./CourseSearchListServlet?cCredit="+ encodeURIComponent( document.getElementById("cCredit").value )
					+ "&cSection=" + encodeURIComponent( document.getElementById("cSection").value)
					+ "&cDepartment=" + encodeURIComponent( document.getElementById("cDepartment").value)
					+ "&cGrade=" + encodeURIComponent( document.getElementById("cGrade").value)
					+ "&cDiv=" + encodeURIComponent( document.getElementById("cDiv").value)
					+ "&cSubDiv=" + encodeURIComponent( document.getElementById("cSubDiv").value)
					+ "&cName=" + encodeURIComponent( document.getElementById("cName").value)
					, true);
			SearchRequest.onreadystatechange = searchcourselistProcess;
			SearchRequest.send(null);
		}
		
		function searchcourselistProcess(){
			var table = document.getElementById("ctable");
			table.innerHTML = "";
			if(SearchRequest.readyState = 4 && SearchRequest.status == 200){
				var object = eval('(' + SearchRequest.responseText + ')');
				var result = object.result;
				console.log(result);
				
				var d3test = d3.select("#ctable")
				.selectAll("tr")
				.data(result)
				.enter()
				.append("tr")
				.attr("class",function(d,i){return "searched-"+i})
				.on("click",searchedchange);
				
				for(var i=0; i<result.length; i++){
					d3.select(".searched-"+i)
					.selectAll("td")
					.data(result[i])
					.enter()
					.append("td")
 					.text(function(d){return d.value;});
					
					d3.select(".searched-"+i)
					.append("td")
					.append("button")
					.on("click",InsertCartfunction)
					.text("추가");
					
				}
				
			}
			$(document).ready(function() {
				$("#ctable tr").on('click',function() {
					$(this).addClass('selected').siblings().removeClass('selected');
				});
			});
			getCartfunction();
		}
		
		function searchedchange(d,i){
			d3.selectAll(".selected")
			.attr("class","");
			
			var selectedcart = d3.select(".searched-"+d[0].value-1);
			selectedcart.attr("class","selected");
		
			var Selected_Course_Time = d[4].value;
			var Selected_Course_ID = d[1].value;
			var Selected_Course_Name = d[2].value;
			var Selected_Course_Professor = d[3].value;
			
			ClearTable();
			var Selected_Course_Time_Array = Selected_Course_Time.split(']');
			for (var i = 0; i < Selected_Course_Time_Array.length - 1; i++) {
				var Time_Array = Selected_Course_Time_Array[i].split('[');
				var cRoom = Time_Array[1];
				var day = Time_Array[0].substring(0, 1);
				var time = Time_Array[0].split(',');
				var cTime = time[0].substring(1);
				var height = 100 * time.length;

				UpdateTable(Time_Array, cRoom, day, time, cTime, height, Selected_Course_ID, Selected_Course_Name, Selected_Course_Professor, "#9DC8C8");
				}
		}

		/*****************************************************************/
		/************ 장바구니 추가 *******************************************/
		/*****************************************************************/
		var InsertRequest = new XMLHttpRequest();
		function InsertCartfunction(d){
				cID = d[1].value;
				InsertRequest.open("Post","./InsertCartServlet?cID="+ encodeURIComponent(cID), true);
				InsertRequest.onreadystatechange = InsertCartProcess;
				InsertRequest.send(null);
		}
		
		function InsertCartProcess(){
			if(InsertRequest.readyState = 4 && InsertRequest.status == 200){
				InsertResult = InsertCartProcess.responseText;
				if(InsertResult == 1){
					alert("장바구니에 추가되었습니다.");
				}
				else if(InsertResult == 0){
					alert("장바구니에 이미 존재하는 수업입니다.");
				}
				else if(InsertResult == -1){
					alert("세션이 만료되어 로그아웃되었습니다.");
				}
			
				getCartfunction();
			}
		}
		
		/*****************************************************************/
		/************ 장바구니 삭제 *******************************************/
		/*****************************************************************/
		var DeleteRequest = new XMLHttpRequest();
		function DeleteCartfunction(d){				
				cID = d[1].value;
 				DeleteRequest.open("Post","./DeleteCartServlet?cID="+ encodeURIComponent(cID), true);
 				DeleteRequest.onreadystatechange = DeleteCartProcess;
 				DeleteRequest.send(null);
		}
		
		function DeleteCartProcess(){
			if(DeleteRequest.readyState = 4 && DeleteRequest.status == 200){
				result = DeleteCartProcess.responseText;
				if(result == 1){
					alert("장바구니에서 삭제되었습니다.");
				}
				else if(result == -1){
					alert("세션이 만료되어 로그아웃되었습니다.");
				}
			
				getCartfunction();
			}
		}
</script>
</html>