package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/page2")
public class Page2Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("login") != null) {
			req.getRequestDispatcher("/WEB-INF/page2.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/login.jsp?erreur=login").forward(req, resp);
		}
	}
}
