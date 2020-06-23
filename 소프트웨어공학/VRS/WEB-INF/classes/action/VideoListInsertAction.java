package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VideoListDAO;

public class VideoListInsertAction implements Action{
	
	//비디오리스트 추가
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		String vlistnum = request.getParameter("vlistnum");
		String vname = request.getParameter("vname");
		String vrelease = request.getParameter("vrelease");
		String vprice = request.getParameter("vprice");
		String vdirector = request.getParameter("vdirector");
		
		VideoListDAO dao = new VideoListDAO();
		dao.insert(vlistnum, vname, vrelease, vprice, vdirector);
	}
}
