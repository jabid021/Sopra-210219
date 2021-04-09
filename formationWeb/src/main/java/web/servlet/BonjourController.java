package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BonjourController
 */
@WebServlet("/bonjour")
public class BonjourController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BonjourController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// controle
		// verification qu'il y a un prenom
		RequestDispatcher rd = null;
		String prenom = null;
		if (request.getParameter("prenom") != null && !request.getParameter("prenom").equals("")) {
			// prenom ok
			prenom = request.getParameter("prenom");
			request.setAttribute("prenom", prenom);
			rd = request.getRequestDispatcher("/WEB-INF/bonjour.jsp");
		} else {
			// pas prenom
			rd = request.getRequestDispatcher("/form.jsp?erreur=true");
		}

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
