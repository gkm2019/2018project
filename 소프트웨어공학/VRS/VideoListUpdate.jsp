<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Video List Update</title>
</head>
<body>
<h1>비디오 리스트 수정</h1>
<form action="VideoListUpdateSave.do" method="post">
비디오 번호<input type="text" name="vlistnum" value="${update.vlistnum}"><br/>
비디오 제목<input type="text" name="vname" value="${update.vname}"><br/>
비디오 감독<input type="text" name="vdirector" value="${update.vdirector}"><br/>
비디오 출판일<input type="text" name="vrelease" value="${update.vrelease}"><br/>
비디오 대여가<input type="text" name="vprice" value="${update.vprice}"><br/>
<input type="submit" value="수정">
</form>
<a href = "VideoList.do">비디오 리스트 목록보기</a>
</body>
</html>