/*
 * Login �솕硫댁뿉�꽌 ID,PW �엯�젰 �떆 �룞�옉�븯�뒗 Login Action 
 */

package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.StudentDAO;

public class LoginCmd implements TTCmd {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String stdID = request.getParameter("stdID");
		String stdPW = request.getParameter("stdPW");
		String NextPage = "";

		
		StudentDAO stdDAO = new StudentDAO();
		int check = stdDAO.Login(stdID, stdPW);
		
		if(check == 1) {
			session.setAttribute("stdID", stdID);
			NextPage = "StudentList.do"; 
		}

		
		else if(check == 0) 
			NextPage = "Login.jsp?check=0&stdID="+stdID;

		else
			NextPage = "Login.jsp?check=-1";

		request.setAttribute("NextPage", NextPage);
		return NextPage;
	}
}

