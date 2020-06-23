package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDAO;
import dto.VideoDTO;

public class VideoInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String vnum = request.getParameter("vnum");
		String vname = request.getParameter("vname");
		String vdirector = request.getParameter("vdirector");
		
		VideoDAO dao = new VideoDAO();
		String vlistnum=dao.insertSearch(vname, vdirector);
		dao.insert(vnum, vlistnum, "0");
	}

}
