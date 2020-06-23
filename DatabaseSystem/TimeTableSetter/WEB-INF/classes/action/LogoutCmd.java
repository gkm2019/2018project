package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCmd implements TTCmd {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
HttpSession session = request.getSession();
		
		String NextPage = "Login.jsp";
		
		session.removeAttribute("stdID");
		
		request.setAttribute("NextPage", NextPage);
		return null;
	}
}