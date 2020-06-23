package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.LogoutCmd;
import action.CheckListCmd;
import action.GongHakCmd;
import action.LoginCmd;
import action.TTCmd;
import action.UserCheckListCmd;
import action.UserListCmd;

/**
 * Servlet implementation class TTController
 */
@WebServlet("*.do")
public class TTController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		
		TTCmd command  = null;
		String nextPage = null;
		
		
		//input으로 입력받은것들 Parameter로 다 가져온다
	      String ghGraduateYear = request.getParameter("ghGraduateYear");
	      String section = request.getParameter("section");
	      String num = request.getParameter("num");
	      String credit = request.getParameter("credit");
	      
	      //session 에서 user정보 가져온다.
	      HttpSession session = request.getSession();
	      session.setAttribute("ghGraduateYear", ghGraduateYear);
	      String stdID=(String)session.getAttribute("stdID");
	      session.setAttribute("num", num);
	      session.setAttribute("credit", credit);
	      
	      if(num==null||credit==null) {num="0";credit="0";}
	      System.out.println("controller에 년도 받음 : "+ghGraduateYear);
	      System.out.println("num : "+num);
	      System.out.println("credit : "+credit);
		
	      //로그인
		if(com.equals("/Login.do")){
			command = new LoginCmd();
			command.execute(request, response);
			//nextPage = (String) request.getAttribute("NextPage");
			nextPage = "SelectCourse.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		}
		
		//로그아웃
				if(com.equals("/Logout.do")) {
					command = new LogoutCmd();
					command.execute(request, response);
					nextPage = (String) request.getAttribute("NextPage");
					RequestDispatcher dis = request.getRequestDispatcher(nextPage);
					dis.forward(request, response);
				}
	
		//사용자 체크리스트 저장
		if(com.equals("/UserCheckList.do")) {
			command = new UserCheckListCmd();
			command.execute(request, response);
			nextPage = "CheckList.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		}
		
		 //공학인증 페이지
		if(com.equals("/CheckList.do")){
			command = new LoginCmd();
			command.execute(request, response);
			//nextPage = (String) request.getAttribute("NextPage");
			nextPage = "CheckList.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		}
		
		
		//전체 리스트
		if(num.equals("1")&&credit!=null) {
			command = new CheckListCmd();
			String CheckListJson=command.execute(request, response);
			TTCmd command2 = new GongHakCmd();
			CheckListJson += command2.execute(request, response);
			response.getWriter().write(CheckListJson);
		}
		
		//사용자 리스트
		if(num.equals("2")&&credit!=null) {
			command = new UserListCmd();
			String UserListJson=command.execute(request, response);
			TTCmd command2 = new GongHakCmd();
			UserListJson +=command2.execute(request, response);
			System.out.println("사용자 리스트?"+UserListJson);
			response.getWriter().write(UserListJson);
		}
		
	}

}

