package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.CourseInfoDO;
import model.dao.TimeTableDAO;
@WebServlet("/TimeTableSetListServlet")
public class TimeTableSetListServlet extends HttpServlet{
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
		TimeTableDAO ttdao = new TimeTableDAO();
		ArrayList<String> TimeTableSetList = ttdao.getTimeTableSetList(stdID);
			
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		for(int i=0;i<TimeTableSetList.size();i++){
			String[] tmp = TimeTableSetList.get(i).split(",");
			result.append("[{\"value\": \"" + tmp[0] + "\"},");
			for(int j=1; j<tmp.length-1; j++) {
				result.append("{\"value\": \"" + tmp[j] + "\"},");
			}
			result.append("{\"value\": \"" + tmp[tmp.length-1] + "\"}],");
		}
		result.append("]}");
		
		
		return result.toString();

	}
	
	
}
