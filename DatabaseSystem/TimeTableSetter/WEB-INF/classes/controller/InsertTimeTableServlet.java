package controller;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CourseCartDAO;
import model.dao.TimeTableDAO;
@WebServlet("/InsertTimeTableServlet")
public class InsertTimeTableServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String stdID = (String) session.getAttribute("stdID");
		String cList = request.getParameter("cList");
		String creditSum = request.getParameter("creditSum");
		String numOfDay = request.getParameter("numOfDay");

		response.getWriter().write(InsertCart(stdID, cList, Integer.parseInt(creditSum), Integer.parseInt(numOfDay)));
	}
	
	public int InsertCart(String stdID, String cList, int creditSum, int numOfDay) {
		if(stdID == null || stdID == "") { // �꽭�뀡�씠 留뚮즺�릺�뼱 濡쒓렇�씤 以묒씠 �븘�땺 �뻹
			return -1;
		}
		
		TimeTableDAO ttdao = new TimeTableDAO();
		String tID = Integer.toString(ttdao.getLasttID(stdID)+1);
		System.out.println(tID);
		int result = ttdao.InsertCart(stdID, cList, tID, creditSum, numOfDay);		
		return result;
	}
}
