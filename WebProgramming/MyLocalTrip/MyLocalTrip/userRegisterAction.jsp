<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.UserDTO"%>
<%@ page import="user.UserDAO"%>
<%@ page import="util.SHA256"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userName=null;
	String userID=null;
	if(session.getAttribute("userID")!=null){
		userID=(String)session.getAttribute("userID");
	}
	if(userID!=null){
		PrintWriter script=response.getWriter();
		script.println("<script>");
		script.println("alert('로그인이 된 상태입니다.');");
		script.println("location.href='main.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
	String userPassword=null;
	String userEmail=null;
	String userEmailHashs = null;
	
	if(request.getParameter("userName")!=null){
		userName=request.getParameter("userName");
	}
	if(request.getParameter("userID")!=null){
		userID=request.getParameter("userID");
	}
	if(request.getParameter("userPassword")!=null){
		userPassword=request.getParameter("userPassword");
	}
	if(request.getParameter("userEmail")!=null){
		userEmail=request.getParameter("userEmail");
	}
	if(userName==null||userID==null||userPassword==null||userPassword==null){
		PrintWriter script=response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}

	UserDAO userDAO=new UserDAO();
	int result = userDAO.Join(new UserDTO(userName,userID,userPassword,userEmail,SHA256.getSHA256(userEmail),false));
	if(result==-1){
		PrintWriter script=response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디입니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	else{
		session.setAttribute("userID",userID);
		PrintWriter script=response.getWriter();
		script.println("<script>");
		script.println("alert('회원 가입이 완료되었습니다. 자동로그인!.');");
		script.println("location.href = 'Login.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
%>