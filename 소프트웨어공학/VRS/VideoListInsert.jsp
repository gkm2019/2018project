<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Video List Insert</title>
</head>
<body>
<h1>���� ����Ʈ �߰�</h1>
<form action="VideoListInsert.do" method="post">
��������Ʈ��ȣ<input type="text" name="vlistnum"><br/>
���� ����<input type="text" name="vname"><br/>
���� ����<input type="text" name="vdirector"><br/>
���� ������<input type="text" name="vrelease"><br/>
���� �뿩��<input type="text" name="vprice"><br/>
<input type="submit" value="����">
</form>
<a href = "VideoList.do">���� ����Ʈ ��Ϻ���</a>
</body>
</html>