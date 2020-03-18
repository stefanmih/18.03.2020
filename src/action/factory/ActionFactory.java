package action.factory;

import action.AbstractAction;
import action.impl.ActionAdd;
import action.impl.ListAllAction;
import action.impl.LoginAction;
import action.impl.LogoutAction;

public class ActionFactory {
	public static AbstractAction createActionFactory(String actionName) {
		AbstractAction action=null;
		if(actionName.equalsIgnoreCase("/login")) {
			action=new LoginAction();
		}
		if(actionName.equalsIgnoreCase("/logout")) {
			action=new LogoutAction();
		}
		if(actionName.equalsIgnoreCase("/all")) {
			action=new ListAllAction();
		}
		if(actionName.equalsIgnoreCase("/add")) {
			action=new ActionAdd();
		}
		return action;
	}
}
