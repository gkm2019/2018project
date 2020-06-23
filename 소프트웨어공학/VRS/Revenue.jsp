<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>매출 관리</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
  <div class="dropdown" style="float:left;">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">비디오
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">추가</a></li>
      <li><a href="#">삭제</a></li>
      <li><a href="#">수정</a></li>
      <li><a href="#">검색</a></li>
    </ul>
  </div>
  <div class="dropdown" style="float:left;">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">비디오리스트
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="#">추가</a></li>
      <li><a href="#">삭제</a></li>
      <li><a href="#">수정</a></li>
      <li><a href="#">검색</a></li>
    </ul>
  </div>
  <div class="dropdown" style="float:left;">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">매출관리
    <span class="caret"></span></button>
  </div>
</div>
<div>
총 지출: ${expendi}<br/>
총 수입: ${income}<br/>
총 매출: ${total}<br/>
</div>

</body>
</html>