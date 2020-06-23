package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OverdueDAO;
import dto.OverdueDTO;

public class OverdueAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		OverdueDAO dao = new OverdueDAO();
		ArrayList<OverdueDTO> list = dao.list();
		request.setAttribute("list", list);
	}

}
