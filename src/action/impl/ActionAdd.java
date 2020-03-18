package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import domain.DataAccessObject;
import domain.User;
import servlet.FrontController;

public class ActionAdd extends AbstractAction {
	public static User p;

	@Override
	public String execute(HttpServletRequest request) {
		String ime, prezime, username, password;
		ime = request.getParameter("ime");
		prezime = request.getParameter("prezime");
		username = request.getParameter("usr");
		password = request.getParameter("pw");
		p = new User(ime, prezime, username, password);
		try {
			if (DataAccessObject.getInstance().isLogged((String) request.getSession().getAttribute("username"))) {
				if (p != null) {
					DataAccessObject.getInstance().add(p);
					p = null;
				}
				System.out.println(p);
				request.setAttribute("user", "Logged in as: " + request.getSession().getAttribute("username"));
			} else {
				return "/application/users/login";
			}
		} catch (Exception e) {
		}
		return "/index.jsp";
	}

}
