package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import domain.DataAccessObject;

public class ActionAllLogged extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request) {
		request.setAttribute("table", DataAccessObject.getInstance().getAllLogged());
		return "/index.jsp";
	}

}
