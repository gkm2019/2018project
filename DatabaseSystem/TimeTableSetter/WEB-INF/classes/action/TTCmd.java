package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TTCmd {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
