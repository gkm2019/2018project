package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CheckListDAO;
import model.dao.UserListDAO;
import model.dto.CourseInfoDTO;

public class UserListCmd implements TTCmd{
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
	      
	      System.out.println("checklistCmd 년도"+ghGraduateYear);
	      /*
	      response.getWriter().write(getJSON(stdID,ghGraduateYear,"교양"));
	      response.getWriter().write(getJSON(stdID,ghGraduateYear,"필수"));
	      response.getWriter().write(getJSON(stdID,ghGraduateYear,"선택"));
	      */
	      
	      String CheckListJson=getJSON(stdID,ghGraduateYear,"교양");
	      CheckListJson+=getJSON(stdID,ghGraduateYear,"필수")+
	    		  		 getJSON(stdID,ghGraduateYear,"선택");
	      
		return CheckListJson;
		
	}
	public String getJSON(String stdID, String ghGraduateYear, String section) {
		CheckListDAO chDAO = new CheckListDAO(); 
		StringBuffer result = new StringBuffer("");
		ArrayList<CourseInfoDTO> ULchList=chDAO.UserCheckList(ghGraduateYear, section, stdID);
		int i,j,k;
		
		if(section.equals("교양")) {
			
			result.append("{\"general\":[");
			
			if(ULchList.size()>1) {
				
			for(i=0;i<ULchList.size()-1;i++) {
				result.append("{\"cName\": \"" + ULchList.get(i).getcName() + "\",");
				result.append("\"cCredit\": \"" + ULchList.get(i).getcCredit() + "\",");
				result.append("\"cID\": \"" + ULchList.get(i).getcID() + "\",");
				result.append("\"cSub\": \"" + ULchList.get(i).getcCredit_sub() + "\"},");
			}
			result.append("{\"cName\": \"" + ULchList.get(i).getcName() + "\",");
			result.append("\"cCredit\": \"" + ULchList.get(i).getcCredit() + "\",");
			result.append("\"cID\": \"" + ULchList.get(i).getcID() + "\",");
			result.append("\"cSub\": \"" + ULchList.get(i).getcCredit_sub() + "\"}],");
			}
			
			else
			{
				if(ULchList.size()==1) {
				result.append("{\"cName\": \"" + ULchList.get(0).getcName() + "\",");
				result.append("\"cCredit\": \"" + ULchList.get(0).getcCredit() + "\",");
				result.append("\"cID\": \"" + ULchList.get(0).getcID() + "\",");
				result.append("\"cSub\": \"" + ULchList.get(0).getcCredit_sub() + "\"}],");
				}
				else if(ULchList.size()==0) {
				result.append("{}],");
				}
				}
		}//교양 if END
		
		else if(section.equals("필수")) {
			
			result.append("\"essen\":[");
			
			if(ULchList.size()>1) {
				
				for(j=0;j<ULchList.size()-1;j++) {
					result.append("{\"cName\": \"" + ULchList.get(j).getcName() + "\",");
					result.append("\"cCredit\": \"" + ULchList.get(j).getcCredit() + "\",");
					result.append("\"cID\": \"" + ULchList.get(j).getcID() + "\",");
					result.append("\"cSub\": \"" + ULchList.get(j).getcCredit_sub() + "\"},");
				}
				result.append("{\"cName\": \"" + ULchList.get(j).getcName() + "\",");
				result.append("\"cCredit\": \"" + ULchList.get(j).getcCredit() + "\",");
				result.append("\"cID\": \"" + ULchList.get(j).getcID() + "\",");
				result.append("\"cSub\": \"" + ULchList.get(j).getcCredit_sub() + "\"}],");
				}
				
				else
				{
					if(ULchList.size()==1) {
					result.append("{\"cName\": \"" + ULchList.get(0).getcName() + "\",");
					result.append("\"cCredit\": \"" + ULchList.get(0).getcCredit() + "\",");
					result.append("\"cID\": \"" + ULchList.get(0).getcID() + "\",");
					result.append("\"cSub\": \"" + ULchList.get(0).getcCredit_sub() + "\"}],");
					}
					else if(ULchList.size()==0) {
					result.append("{}],");
					}
					}
			
		}//선택 if END
		
		else if(section.equals("선택")) {
			result.append("\"option\":[");
			
			if(ULchList.size()>1) {
				
				for(k=0;k<ULchList.size()-1;k++) {
					result.append("{\"cName\": \"" + ULchList.get(k).getcName() + "\",");
					result.append("\"cCredit\": \"" + ULchList.get(k).getcCredit() + "\",");
					result.append("\"cID\": \"" + ULchList.get(k).getcID() + "\",");
					result.append("\"cSub\": \"" + ULchList.get(k).getcCredit_sub() + "\"},");
				}
				result.append("{\"cName\": \"" + ULchList.get(k).getcName() + "\",");
				result.append("\"cCredit\": \"" + ULchList.get(k).getcCredit() + "\",");
				result.append("\"cID\": \"" + ULchList.get(k).getcID() + "\",");
				result.append("\"cSub\": \"" + ULchList.get(k).getcCredit_sub() + "\"}],");
				}
				
				else
				{
					if(ULchList.size()==1) {
					result.append("{\"cName\": \"" + ULchList.get(0).getcName() + "\",");
					result.append("\"cCredit\": \"" + ULchList.get(0).getcCredit() + "\",");
					result.append("\"cID\": \"" + ULchList.get(0).getcID() + "\",");
					result.append("\"cSub\": \"" + ULchList.get(0).getcCredit_sub() + "\"}],");
					}
					else if(ULchList.size()==0) {
					result.append("{}],");
					}
					}
		}//선택 if END
		
		return result.toString();
	}
}
