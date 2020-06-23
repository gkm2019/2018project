<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="evaluation. *" %>
<%@ page import="util. *" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%
   request.setCharacterEncoding("UTF-8");
   String userID = null;
   if(session.getAttribute("userID")!=null){
      userID=(String)session.getAttribute("userID");
   }
   if(userID==null){
      PrintWriter script=response.getWriter();
      script.println("<script>");
      script.println("alert('로그인을 해주세요.')");
      script.println("location.href='Login.jsp';");
      script.println("</script>");
      script.close();
      return;
   }
   
   String age=null;
   String reviewDivide=null;
   String evaluationTitle=null;
   String evaluationContent=null;
   String totalScore=null;
   String recomendScore=null;
   int course_idx=0;
   
   
   if(request.getParameter("age")!=null){
      age=request.getParameter("age");
   }
   if(request.getParameter("reviewDivide")!=null){
      reviewDivide=request.getParameter("reviewDivide");
   }
   if(request.getParameter("evaluationTitle")!=null){
      evaluationTitle=request.getParameter("evaluationTitle");
   }
   if(request.getParameter("evaluationContent")!=null){
      evaluationContent=request.getParameter("evaluationContent");
   }
   if(request.getParameter("totalScore")!=null){
      totalScore=request.getParameter("totalScore");
   }
   if(request.getParameter("recomendScore")!=null){
      recomendScore=request.getParameter("recomendScore");
   }
   if(request.getParameter("course_idx")!=null){
	   String temp=request.getParameter("course_idx");
	   System.out.println("course_idx받아온값은?="+request.getParameter("course_idx"));
	   
	   course_idx = Integer.parseInt(temp);
	   System.out.println("옮겨담은 course_idx=?"+course_idx);	   
	   
   }

   if(age==null||reviewDivide==null||evaluationTitle.equals("")||evaluationContent.equals("")||
         totalScore==null){
      PrintWriter script =response.getWriter();
      script.println("<script>");
      script.println("alert('입력이 안 된 항목이 있습니다.');");
      script.println("history.back()");
      script.println("</script>");
      script.close();
      return;
   }
   EvaluationDAO evaluationDAO=new EvaluationDAO();
   int result = evaluationDAO.write(new EvaluationDTO( 0,  userID,  age,  reviewDivide,
          evaluationTitle,  evaluationContent,  totalScore,  recomendScore,  0
         ,course_idx));
   if(result==-1){       
      PrintWriter script=response.getWriter();
      script.println("<script>");
      script.println("alert('후기 등록 실패했습니다.');");
      script.println("history.back();");
      script.println("</script>");
      script.close();
      return;
   }
   else{
      session.setAttribute("userID",userID);
      PrintWriter script=response.getWriter();
      System.out.println("action 페이지에서 받은 course_idx는?"+request.getParameter("course_idx"));
      String temp2=request.getParameter("course_idx");
      int temp3=Integer.parseInt(temp2);
      temp3--;
      
      script.println("<script>");
      script.println("alert('후기작성 완료')");
      script.println("location.href='Course_page.jsp?courseidx="+temp3+"'");
      script.println("</script>");
      script.close();
      return;
   }
%>