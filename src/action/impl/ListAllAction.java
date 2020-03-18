package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import domain.DataAccessObject;

public class ListAllAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		if (request.getParameter("loggedall") != null) {
			if (request.getSession().getAttribute("username")==null||request.getSession().getAttribute("username").equals("")) {
				return "/application/users/login";
			} else {
				request.setAttribute("table", DataAccessObject.getInstance().getAllLogged());
				request.setAttribute("user", "Logged in as: " + request.getSession().getAttribute("username"));
			}
		} else {
			request.setAttribute("table", DataAccessObject.getInstance().getAll());
			request.setAttribute("user", "Logged in as: " + request.getSession().getAttribute("username"));
		}
		return "/index.jsp";
	}

}
