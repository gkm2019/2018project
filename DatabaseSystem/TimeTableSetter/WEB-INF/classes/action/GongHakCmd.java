package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CheckListDAO;
import model.dao.UserListDAO;
import model.dto.CourseInfoDTO;
import model.dao.GongHakDAO;
import model.dto.GongHakDTO;

public class GongHakCmd implements TTCmd{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		
		//input으로 입력받은것들 Parameter로 다 가져온다
	      String ghGraduateYear = request.getParameter("ghGraduateYear");
	      String section = request.getParameter("section");
	      
	      //session 에서 user정보 가져온다.
	      HttpSession session = request.getSession();
	      session.setAttribute("ghGraduateYear", ghGraduateYear);
	      String stdID=(String)session.getAttribute("stdID");
	      
	      String CheckListJson=getJSON(ghGraduateYear);
	      
		return CheckListJson;
		
	}
	public String getJSON(String ghGraduateYear) {
		GongHakDAO GHDAO = new GongHakDAO();
		StringBuffer result = new StringBuffer("");
		GongHakDTO GHList = GHDAO.GongHak(ghGraduateYear);
			
		result.append("\"GH\":[");
		result.append("{\"ghGeneral\": \""+GHList.getGhGeneral()+"\"},");
		result.append("{\"ghEssen\": \""+GHList.getGhEssential()+"\"},");
		result.append("{\"ghEssen_sub\": \""+GHList.getGhEssential_sub()+"\"},");
		result.append("{\"ghOP\": \""+GHList.getGhOption()+"\"},");
		result.append("{\"ghOP_sub\": \""+GHList.getGhOption_sub()+"\"}]}");
							
		
		return result.toString();
	}
}
