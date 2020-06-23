package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CourseCartDAO;
import model.dto.CourseInfoDO;
import util.TTConditionalSearch;
@WebServlet("/CourseSearchListServlet")
public class CourseSearchListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String stdID = (String) session.getAttribute("stdID");
		String cCredit = request.getParameter("cCredit");
		String cSection = request.getParameter("cSection");
		String cDepartment = request.getParameter("cDepartment");
		String cGrade = request.getParameter("cGrade");
		String cDiv = request.getParameter("cDiv");
		String cSubDiv = request.getParameter("cSubDiv");
		String cName = request.getParameter("cName");
		String cID = request.getParameter("cID");
		
		response.getWriter().write(getJSON(cCredit, cSection, cDepartment, cGrade, cDiv, cSubDiv, cName));
	}
	
	public String getJSON(String cCredit, String cSection, String cDepartment, String cGrade, String cDiv, String cSubDiv, String cName) {
		if(cCredit == null) cCredit = "";
		if(cSection == null) cSection = "";
		if(cDepartment == null) cDepartment = "";
		if(cGrade == null) cGrade = "";
		if(cDiv == null) cDiv = "";
		if(cSubDiv == null) cSubDiv = "";
		if(cName == null) cName = "";
		
		// 寃��깋議곌굔�뿉 留욌뒗 �닔�뾽 紐⑸줉 遺덈윭�샂
		// 寃��깋議곌굔�뿉 留욌뒗 �닔�뾽 紐⑸줉 遺덈윭�샂
		TTConditionalSearch SearchTool = new TTConditionalSearch();
		ArrayList<CourseInfoDO> Searched_Course_List = SearchTool.ConditionalSearch(cCredit, cSection, cDepartment, cGrade, cDiv, cSubDiv, "%"+cName+"%");
					
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		for(int i=0;i<Searched_Course_List.size();i++){
			result.append("[{\"value\": \""+(i+1) + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcID() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcName() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcProfessor() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcTime() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcCredit() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcCredit_sub() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcDepartment() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcDiv() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getcSubDiv() + "\"},");
			result.append("{\"value\": \""+Searched_Course_List.get(i).getLimit_per() + "\"}],");
		}
		result.append("]}");
		
		System.out.println(result);
		
		return result.toString();

	}
	
	
}
