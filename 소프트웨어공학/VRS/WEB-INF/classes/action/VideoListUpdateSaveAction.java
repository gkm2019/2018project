package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoListDAO;

public class VideoListUpdateSaveAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String vlistnum = request.getParameter("vlistnum");
		String vname = request.getParameter("vname");
		String vdirector = request.getParameter("vdirector");
		String vrelease = request.getParameter("vrelease");
		String vprice = request.getParameter("vprice");
		
		System.out.println(vlistnum);
		VideoListDAO dao = new VideoListDAO();
		dao.updateSave(vlistnum, vname, vdirector, vrelease, vprice);
	}

}
