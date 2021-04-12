package web.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import formation.entity.Commande;
import formation.entity.Personne;
import formation.repositories.CommandeRepository;
import formation.repositories.PersonneRepository;

/**
 * Servlet implementation class CommandeController
 */
@WebServlet("/commande")
public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommandeRepository commandeRepository;
	private PersonneRepository personneRepository;

	@Override
	public void init() throws ServletException {
		ApplicationContext applicationContext = ((ApplicationContext) this.getServletContext().getAttribute("spring"));
		commandeRepository = applicationContext.getBean(CommandeRepository.class);
		personneRepository = applicationContext.getBean(PersonneRepository.class);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("query");
		RequestDispatcher rd = null;
		if (query == null || query.isEmpty()) {
			// liste des commandes
			rd = list(request, response);
		} else if (query.equals("add")) {
			rd = add(request, response);
		} else if (query.equals("save")) {
			rd = save(request, response);
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

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("commandes", commandeRepository.findAll());
		return request.getRequestDispatcher("/WEB-INF/commande/list.jsp");
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("commande", new Commande());
		request.setAttribute("clients", personneRepository.findAll());
		return request.getRequestDispatcher("/WEB-INF/commande/add.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		String dateCommande = request.getParameter("dateCommande");
		Integer id = Integer.parseInt(request.getParameter("client.id"));
		Commande commande = new Commande();
		LocalDate ld = LocalDate.parse(dateCommande);
		commande.setDateCommande(ld);
		Personne client = new Personne();
		client.setId(id);
		commande.setClient(client);
		commandeRepository.save(commande);
		return list(request, response);
	}

}
