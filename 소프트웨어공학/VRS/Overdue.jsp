<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ü�� ���</title>
</head>
<body>
<h1>��ü�ڸ��</h1>
<table border="1">
<tr>
<td>��ü �� ID</td>
<td>���� ��ȣ</td>
<td>���� ����</td>
<td>��ü ��¥</td>
</tr>
<c:forEach items="${list}" var="dto">
<tr>
<td>${dto.cid}</td>
<td>${dto.vnum}</td>
<td>${dto.vname}</td>
<td>${dto.overdueday}</td>
</tr>
</c:forEach>
</table>
</body>
</html>