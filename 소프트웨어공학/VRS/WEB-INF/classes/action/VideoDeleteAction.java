package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDAO;

public class VideoDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String vnum = request.getParameter("vnum");
		VideoDAO dao = new VideoDAO();
		dao.delete(vnum);
	}

}
