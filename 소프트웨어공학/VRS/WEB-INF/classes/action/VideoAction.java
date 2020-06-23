package action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VideoDAO;
import dto.VideoDTO;

public class VideoAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		VideoDAO dao = new VideoDAO();
		ArrayList<VideoDTO> list = dao.list();
		request.setAttribute("list", list);
		
	}
}
