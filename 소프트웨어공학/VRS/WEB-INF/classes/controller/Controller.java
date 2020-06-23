package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.OverdueAction;
import action.RevenueAction;
import action.VideoAction;
import action.VideoDeleteAction;
import action.VideoInsertAction;
import action.VideoListAction;
import action.VideoListDeleteAction;
import action.VideoListInsertAction;
import action.VideoListRetrieveAction;
import action.VideoListUpdateAction;
import action.VideoListUpdateSaveAction;
import action.VideoRetrieveAction;

@WebServlet("*.do")
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		
		Action command = null;
		String nextPage = null;
		HttpSession session = request.getSession();
		
		//form양식 parameter로 가져온다.
		//session에서 정보 가져온다
		////////////////////////
		//비디오관리
		if(com.equals("/Video.do")) {
			command = new VideoAction();
			command.execute(request, response);
			nextPage = "Video.jsp";
		}
		//비디오 insert
		if(com.equals("/VideoInsert.do")) {
			command = new VideoInsertAction();
			command.execute(request, response);
			nextPage = "VideoInsert.jsp";
		}
		//비디오 Form
		if(com.equals("/insertform.do")) {
			nextPage = "VideoInsert.jsp";
		}
		//비디오delete
		if(com.equals("/VideoDelete.do")) {
			command = new VideoDeleteAction();
			command.execute(request, response);
			nextPage = "Video.do";
		}
		//비디오리스트 retrieve
		if(com.equals("/VideoRetrieve.do")) {
			command = new VideoRetrieveAction();
			command.execute(request, response);
			nextPage = "Video.jsp";
		}
		////////////////////////
		//비디오리스트 
		if(com.equals("/VideoList.do")) {
			command = new VideoListAction();
			command.execute(request, response);
			nextPage = "VideoList.jsp";
		}
		//비디오리스트 insert
		if(com.equals("/VideoListInsert.do")) {
			command = new VideoListInsertAction();
			command.execute(request, response);
			nextPage = "VideoListInsert.jsp";
		}
		//비디오리스트 Form
		if(com.equals("/insertform.do")) {
			nextPage = "VideoListInsert.jsp";
		}
		//비디오리스트 update
		if(com.equals("/VideoListUpdate.do")) {
			command = new VideoListUpdateAction();
			command.execute(request, response);
			nextPage = "VideoListUpdate.jsp";
		}
		//비디오리스트 updateSave
		if(com.equals("/VideoListUpdateSave.do")) {
			command = new VideoListUpdateSaveAction();
			command.execute(request, response);
			nextPage="VideoList.do";
		}
		//비디오리스트 delete
		if(com.equals("/VideoListDelete.do")) {
			command = new VideoListDeleteAction();
			command.execute(request, response);
			nextPage = "VideoList.do";
		}
		//비디오리스트 retrieve
		if(com.equals("/VideoListRetrieve.do")) {
			command = new VideoListRetrieveAction();
			command.execute(request, response);
			nextPage = "VideoList.jsp";
		}
        ////////////////////////
		//매출관리
		if(com.equals("/Revenue.do")) {
			command = new RevenueAction();
			command.execute(request, response);
			nextPage = "Revenue.jsp";
		}
		//연체관리
		if(com.equals("/Overdue.do")) {
			command = new OverdueAction();
			command.execute(request, response);
			nextPage = "Overdue.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}
}
