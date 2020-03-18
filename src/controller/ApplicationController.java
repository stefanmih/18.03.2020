package controller;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import action.factory.ActionFactory;

public class ApplicationController {

	public String processRequest(String pathInfo, HttpServletRequest request) {
		String page="/WEB-INF/pages/error/defaulterrorpage.jsp";
		AbstractAction action=ActionFactory.createActionFactory(pathInfo);
		if(action!=null) {
			page=action.execute(request);
		}
		return page;
	}

}
