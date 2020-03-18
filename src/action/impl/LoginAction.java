package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import domain.DataAccessObject;
import domain.User;
import servlet.FrontController;

public class LoginAction extends AbstractAction {
	public String user = "";

	@Override
	public String execute(HttpServletRequest request) {
		user = request.getParameter("username");
		if (DataAccessObject.getInstance().findUser(request.getParameter("username"),
				request.getParameter("password"))) {
			if (DataAccessObject.getInstance().isLogged(request.getParameter("username"))) {
				DataAccessObject.getInstance().add(ActionAdd.p);
				return "/index.jsp";
			}
			request.setAttribute("user", "Logged in as: " + request.getParameter("username"));
			request.setAttribute("username", request.getAttribute("username"));
			if (ActionAdd.p != null) {
				DataAccessObject.getInstance().add(ActionAdd.p);
				ActionAdd.p = null;
			}
			DataAccessObject.getInstance().addLoggedUser(request.getParameter("username"));
			request.getSession().setAttribute("username", user);
			return "/index.jsp";
		} else {
			request.setAttribute("error", "Invalid username/password or you are not logged in.");
			return "/WEB-INF/pages/login.jsp";
		}
	}

}
