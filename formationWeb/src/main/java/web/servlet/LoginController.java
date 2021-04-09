package web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
			rd = request.getRequestDispatcher("login.jsp?erreur=empty");
		} else if (login.equals("toto") && password.equals("toto")) {
			rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
			// request.setAttribute("login", login);
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			Cookie c = new Cookie("cookie1", "mon_cookie");
			c.setMaxAge(3600 * 24 * 7);
			response.addCookie(c);
		} else {
			rd = request.getRequestDispatcher("login.jsp?erreur=true");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
