<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO"%>
<%@ page import="evaluation.EvaluationDAO"%>
<%@ page import="user.LikeyDAO"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!

public static String getClientIP(HttpServletRequest request) {

    String ip = request.getHeader("X-FORWARDED-FOR"); 

    if (ip == null || ip.length() == 0) {

        ip = request.getHeader("Proxy-Client-IP");

    }

    if (ip == null || ip.length() == 0) {

        ip = request.getHeader("WL-Proxy-Client-IP");

    }

    if (ip == null || ip.length() == 0) {

        ip = request.getRemoteAddr() ;

    }

    return ip;

}

%>

<%

	String userID = null;

	if(session.getAttribute("userID") != null) {

		userID = (String) session.getAttribute("userID");

	}

	if(userID == null) {

		PrintWriter script = response.getWriter();

		script.println("<script>");

		script.println("alert('로그인을 해주세요.');");

		script.println("location.href = 'login.jsp'");

		script.println("</script>");

		script.close();

		return;

	}
	%>