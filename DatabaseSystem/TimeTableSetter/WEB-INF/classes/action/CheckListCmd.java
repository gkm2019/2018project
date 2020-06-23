package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CheckListDAO;
import model.dao.UserListDAO;
import model.dto.CourseInfoDTO;

//����� ���� üũ����Ʈ �����ϱ�
public class CheckListCmd implements TTCmd{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		
		  //input���� �Է¹����͵� Parameter�� �� �����´�
	      String ghGraduateYear = request.getParameter("ghGraduateYear");
	      String section = request.getParameter("section");
	      
	      //session ���� user���� �����´�.
	      HttpSession session = request.getSession();
	      session.setAttribute("ghGraduateYear", ghGraduateYear);
	      String stdID=(String)session.getAttribute("stdID");
	      
	      System.out.println("checklistCmd �⵵"+ghGraduateYear);
	     
	      String CheckListJson=getJSON(stdID,ghGraduateYear,"����");
	      CheckListJson+=getJSON(stdID,ghGraduateYear,"�ʼ�")+
	    		  		 getJSON(stdID,ghGraduateYear,"����");
	      
		return CheckListJson;
		
	}
	
	public String getJSON(String stdID, String ghGraduateYear, String section) {

	      CheckListDAO chDAO = new CheckListDAO(); 
	      StringBuffer result = new StringBuffer("");
	      ArrayList<CourseInfoDTO> chList=chDAO.CheckList(ghGraduateYear, section);
	      ArrayList<CourseInfoDTO> ULchList=chDAO.UserCheckList(ghGraduateYear, section, stdID);
	      int i,j,k;
	      
	      if(section.equals("����")) {
	         result.append("{\"general\":[");
	      
	         for(i=0;i<chList.size()-1;i++) {
	            result.append("{\"cName\": \"" + chList.get(i).getcName() + "\",");
	            result.append("\"cCredit\": \"" + chList.get(i).getcCredit() + "\",");
	            result.append("\"cID\": \"" + chList.get(i).getcID() + "\",");
	            result.append("\"cSub\": \"" + chList.get(i).getcCredit_sub() + "\"},");
	         }
	         result.append("{\"cName\": \"" + chList.get(i).getcName() + "\",");
	         result.append("\"cCredit\": \"" + chList.get(i).getcCredit() + "\",");
	         result.append("\"cID\": \"" + chList.get(i).getcID() + "\",");
	         result.append("\"cSub\": \"" + chList.get(i).getcCredit_sub() + "\"}],");
	      }
	      
	      else if(section.equals("�ʼ�")) {
	         result.append("\"essen\":[");
	         
	         for(j=0;j<chList.size()-1;j++) {
	            result.append("{\"cName\": \"" + chList.get(j).getcName() + "\",");
	            result.append("\"cCredit\": \"" + chList.get(j).getcCredit() + "\",");
	            result.append("\"cID\": \"" + chList.get(j).getcID() + "\",");
	            result.append("\"cSub\": \"" + chList.get(j).getcCredit_sub() + "\"},");
	         }
	         result.append("{\"cName\": \"" + chList.get(j).getcName() + "\",");
	         result.append("\"cCredit\": \"" + chList.get(j).getcCredit() + "\",");
	         result.append("\"cID\": \"" + chList.get(j).getcID() + "\",");
	         result.append("\"cSub\": \"" + chList.get(j).getcCredit_sub() + "\"}],");
	         }
	      
	      else if(section.equals("����")) {
	         result.append("\"option\":[");
	         
	         for(k=0;k<chList.size()-1;k++) {
	            result.append("{\"cName\": \"" + chList.get(k).getcName() + "\",");
	            result.append("\"cCredit\": \"" + chList.get(k).getcCredit() + "\",");
	            result.append("\"cID\": \"" + chList.get(k).getcID() + "\",");
	            result.append("\"cSub\": \"" + chList.get(k).getcCredit_sub() + "\"},");
	         }
	         result.append("{\"cName\": \"" + chList.get(k).getcName() + "\",");
	         result.append("\"cCredit\": \"" + chList.get(k).getcCredit() + "\",");
	         result.append("\"cID\": \"" + chList.get(k).getcID() + "\",");
	         result.append("\"cSub\": \"" + chList.get(k).getcCredit_sub() + "\"}],");
	      }
	      
	      return result.toString();
	   }

}
