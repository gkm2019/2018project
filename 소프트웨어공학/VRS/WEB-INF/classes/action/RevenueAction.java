package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RevenueDAO;

public class RevenueAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		RevenueDAO income_dao = new RevenueDAO();
		RevenueDAO expendi_dao = new RevenueDAO();
	    int income = income_dao.income();
		int expendi = expendi_dao.expenditure();
		int total =  income_dao.income()-expendi_dao.expenditure();
		
		request.setAttribute("income", income);
		request.setAttribute("expendi", expendi);
		request.setAttribute("total", total);
	}

}
