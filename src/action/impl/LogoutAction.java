package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import servlet.FrontController;

public class LogoutAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().setAttribute("username", "");
		request.getSession().invalidate();
		request.setAttribute("user", "Logged in as: "+request.getSession().getAttribute("username"));
		
		return "/index.jsp";
	}

}
