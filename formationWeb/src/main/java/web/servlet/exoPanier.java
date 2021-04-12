package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import formation.repositories.CommandeRepository;
import formation.repositories.LigneCommandeRepository;
import formation.repositories.PersonneRepository;
import formation.repositories.ProduitRepository;

/**
 * Servlet implementation class exoPanier
 */
@WebServlet("/exoPanier")
public class exoPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeRepository commandeRepository;
	private PersonneRepository personneRepository;
	private ProduitRepository produitRepository;
	private LigneCommandeRepository ligneCommandeRepository;

	@Override
	public void init() throws ServletException {
		ApplicationContext applicationContext = ((ApplicationContext) this.getServletContext().getAttribute("spring"));
		commandeRepository = applicationContext.getBean(CommandeRepository.class);
		personneRepository = applicationContext.getBean(PersonneRepository.class);
		ligneCommandeRepository = applicationContext.getBean(LigneCommandeRepository.class);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
