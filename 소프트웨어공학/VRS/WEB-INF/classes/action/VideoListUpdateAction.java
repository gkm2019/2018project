package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoListDAO;
import dto.VideoListDTO;

public class VideoListUpdateAction implements Action{
	//��������Ʈ �߰�
		public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
			// TODO Auto-generated method stub
			String vlistnum = request.getParameter("vlistnum");
			
			VideoListDAO dao = new VideoListDAO();
			VideoListDTO dto = dao.update(vlistnum);
			
			request.setAttribute("update", dto);
		
		}
}
