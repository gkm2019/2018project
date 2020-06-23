package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoListDAO;
import dto.VideoListDTO;

public class VideoListRetrieveAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String searchVideoList = request.getParameter("searchVideoList");
		String searchValue = request.getParameter("searchValue");
		
		VideoListDAO dao = new VideoListDAO();
		ArrayList<VideoListDTO> list = dao.retrieve(searchVideoList, searchValue);
		
		request.setAttribute("list", list);
	}

}
