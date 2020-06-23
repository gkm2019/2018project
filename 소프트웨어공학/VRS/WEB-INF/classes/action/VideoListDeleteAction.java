package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoListDAO;

public class VideoListDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String vlistnum = request.getParameter("vlistnum");
		
		VideoListDAO dao = new VideoListDAO();
		dao.delete(vlistnum);
	}
}
