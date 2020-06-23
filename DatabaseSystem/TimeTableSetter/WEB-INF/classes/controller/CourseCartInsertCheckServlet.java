package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CourseCartDAO;
@WebServlet("/CourseCartInsertCheckServlet")
public class CourseCartInsertCheckServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String stdID = (String) session.getAttribute("stdID");
		
		String cID = request.getParameter("cID");
		response.getWriter().write(new CourseCartDAO().InsertCartCheck(stdID, cID)+"");
	}
}
