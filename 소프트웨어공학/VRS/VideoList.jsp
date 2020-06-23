<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Video List</title>
</head>
<body>
<h1>���� ����Ʈ</h1>
<table border="1">
<tr>
<td colspan = "7">
<form action ="VideoListRetrieve.do" method="post">
<select name = "searchVideoList" size="1">
<option value = "vname">��������</option>
<option value = "vdirector">������</option>
</select>
<input type="text" name="searchValue">
<input type="submit" value="search">
</form>
</td>
</tr>
<tr>
<td>��ȣ</td>
<td>����</td>
<td>����</td>
<td>������</td>
<td>�뿩��</td>
</tr>
<c:forEach items="${list}" var="dto">
<tr>
<td>${dto.vlistnum}</td>
<td>${dto.vname}</td>
<td>${dto.vdirector}</td>
<td>${dto.vrelease}</td>
<td>${dto.vprice}</td>
<td><a href = "VideoListUpdate.do?vlistnum=${dto.vlistnum}">����</a></td>
<td><a href = "VideoListDelete.do?vlistnum=${dto.vlistnum}">����</a></td>
</tr>
</c:forEach>
</table>
<a href="VideoListInsert.do">�߰�</a>
</body>
</html>