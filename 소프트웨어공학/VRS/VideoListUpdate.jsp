<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Video List Update</title>
</head>
<body>
<h1>���� ����Ʈ ����</h1>
<form action="VideoListUpdateSave.do" method="post">
���� ��ȣ<input type="text" name="vlistnum" value="${update.vlistnum}"><br/>
���� ����<input type="text" name="vname" value="${update.vname}"><br/>
���� ����<input type="text" name="vdirector" value="${update.vdirector}"><br/>
���� ������<input type="text" name="vrelease" value="${update.vrelease}"><br/>
���� �뿩��<input type="text" name="vprice" value="${update.vprice}"><br/>
<input type="submit" value="����">
</form>
<a href = "VideoList.do">���� ����Ʈ ��Ϻ���</a>
</body>
</html>