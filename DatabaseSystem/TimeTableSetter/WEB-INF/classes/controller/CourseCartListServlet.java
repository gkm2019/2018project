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
@WebServlet("/CourseCartListServlet")
public class CourseCartListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String stdID = (String) session.getAttribute("stdID");
		
		response.getWriter().write(getJSON(stdID));
	}
	
	public String getJSON(String stdID) {
		if(stdID == null) stdID = "";
		
		// 寃��깋議곌굔�뿉 留욌뒗 �닔�뾽 紐⑸줉 遺덈윭�샂
		CourseCartDAO cartdao = new CourseCartDAO();
		ArrayList<CourseInfoDO> cartlist = cartdao.getCartList(stdID);
		
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		for(int i=0;i<cartlist.size();i++){
			result.append("[{\"value\": \""+(i+1) + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcID() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcName() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcProfessor() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcTime() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcCredit() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcCredit_sub() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcDepartment() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcDiv() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getcSubDiv() + "\"},");
			result.append("{\"value\": \""+cartlist.get(i).getLimit_per() + "\"}],");
		}
		result.append("]}");
		
		
		
		return result.toString();

	}
	
	
}
