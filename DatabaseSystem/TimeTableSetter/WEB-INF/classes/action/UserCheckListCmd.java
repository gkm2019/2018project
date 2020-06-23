package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserListDAO;

//사용자 별로 체크리스트 저장하기
public class UserCheckListCmd implements TTCmd{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		UserListDAO ULdao = new UserListDAO();
		String stdID=(String)session.getAttribute("stdID");
		String ghGraduateYear=(String)session.getAttribute("ghGraduateYear");
	
		
		String count = request.getParameter("count");
		String jsonStr = request.getParameter("cID");
		int cnt = Integer.parseInt(count);
		jsonStr="&"+jsonStr; //split하기 위해 앞에 &붙여서 규칙 맞추기
		
		String[] cID=null;
		String sp = "&whether=";
		cID = jsonStr.split(sp);
	
		for(int i = 1; i<=cnt;i++) {
			System.out.println(i+"번째 cID : "+cID[i]);
			
			if(cID[i]!=null&&ghGraduateYear!=null&&stdID!=null)
				ULdao.SaveCheckList(stdID, ghGraduateYear, cID[i]);
		}
		
		System.out.println("UserCheckListCmd에서 //"+ghGraduateYear);
		System.out.println("UserCheckListCmd에서 //"+stdID);
		return null;
		
	}
}
