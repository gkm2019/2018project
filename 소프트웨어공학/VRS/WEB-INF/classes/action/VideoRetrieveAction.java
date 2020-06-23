package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDAO;
import dto.VideoDTO;

public class VideoRetrieveAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String searchVideo = request.getParameter("searchVideo");
		String searchValue = request.getParameter("searchValue");
		VideoDAO dao = new VideoDAO();
		ArrayList<VideoDTO> list = dao.retrieve(searchVideo, searchValue);
		request.setAttribute("list", list);
	}

}
