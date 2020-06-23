package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserListDAO;

//����� ���� üũ����Ʈ �����ϱ�
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
		jsonStr="&"+jsonStr; //split�ϱ� ���� �տ� &�ٿ��� ��Ģ ���߱�
		
		String[] cID=null;
		String sp = "&whether=";
		cID = jsonStr.split(sp);
	
		for(int i = 1; i<=cnt;i++) {
			System.out.println(i+"��° cID : "+cID[i]);
			
			if(cID[i]!=null&&ghGraduateYear!=null&&stdID!=null)
				ULdao.SaveCheckList(stdID, ghGraduateYear, cID[i]);
		}
		
		System.out.println("UserCheckListCmd���� //"+ghGraduateYear);
		System.out.println("UserCheckListCmd���� //"+stdID);
		return null;
		
	}
}
