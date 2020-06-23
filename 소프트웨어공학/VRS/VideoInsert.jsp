<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Video Insert</title>
</head>
<body>
<h1>비디오 추가(이름과 감독 정보로 추가)</h1>
<form action="VideoInsert.do" method="post">
비디오번호<input type="text" name="vnum"><br/>
비디오 제목<input type="text" name="vname"><br/>
비디오 감독<input type="text" name="vdirector"><br/>
<input type="submit" value="저장">
</form>
<a href = "Video.do">비디오 목록보기</a>
</body>
</html>