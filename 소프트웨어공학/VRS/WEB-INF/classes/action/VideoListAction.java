package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VideoListDAO;
import dto.VideoListDTO;

public class VideoListAction implements Action{
	
	//��������Ʈ �߰�
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		VideoListDAO dao = new VideoListDAO();
		ArrayList<VideoListDTO> list = dao.list();
		request.setAttribute("list", list);
	}
}
