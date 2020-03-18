package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.ApplicationController;
import domain.DataAccessObject;

@WebServlet("/application/users/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationController applicationController;
	public FrontController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		applicationController = new ApplicationController();
		System.out.println("Kreiran ac");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DataAccessObject.getInstance();
		System.out.println(DataAccessObject.loggedUsers);
		System.out.println(request.getPathInfo());
		request.getRequestDispatcher(applicationController.processRequest(request.getPathInfo(), request)).forward(request, response);
	}

}
