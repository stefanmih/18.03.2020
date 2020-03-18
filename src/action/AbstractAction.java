package action;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractAction {
public int a;

public abstract String execute(HttpServletRequest request);
}
