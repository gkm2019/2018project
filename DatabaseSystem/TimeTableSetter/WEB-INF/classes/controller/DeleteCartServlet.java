package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CourseCartDAO;
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String stdID = (String) session.getAttribute("stdID");
		String cID = request.getParameter("cID");
		response.getWriter().write(DeleteCart(stdID,cID));
	}
	
	public int DeleteCart(String stdID, String cID) {
		if(stdID == null || stdID == "") { // �꽭�뀡�씠 留뚮즺�릺�뼱 濡쒓렇�씤 以묒씠 �븘�땺 �뻹
			return -1;
		}
		CourseCartDAO cartdao = new CourseCartDAO();
		int result = cartdao.DeleteCart(stdID, cID);
		return result;
	}
}
