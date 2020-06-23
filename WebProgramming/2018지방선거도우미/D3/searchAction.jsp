<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="candidate .*" %>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String candi_name = null;
		candi_name=request.getParameter("candi_name");
		System.out.println("candi_name값은?"+candi_name);
		session.setAttribute("candi_name",candi_name);
		
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.print("location.href=\'search.jsp");
	
			script.print("\'");
			script.println("</script>");
	
	
				
		%>
</body>
</html>