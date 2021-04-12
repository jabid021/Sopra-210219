package web.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import formation.entity.Commande;
import formation.entity.LigneCommande;
import formation.entity.LigneCommandePK;
import formation.entity.Personne;
import formation.entity.Produit;
import formation.repositories.CommandeRepository;
import formation.repositories.LigneCommandeRepository;
import formation.repositories.PersonneRepository;
import formation.repositories.ProduitRepository;

/**
 * Servlet implementation class exoPanier
 */
@WebServlet("/panier")
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
		produitRepository = applicationContext.getBean(ProduitRepository.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("query");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		if (query == null || query.isEmpty()) {
			rd = list(request, response);
		} else if (query.equals("save")) {

		} else if (query.equals("add")) {
			rd = add(request, response);
		} else if (query.equals("remove")) {

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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/exo/panier.jsp");
		request.setAttribute("produits", produitRepository.findAll());
		return rd;
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Produit produit = produitRepository.findById(id).get();
		HttpSession session = request.getSession();
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + 1);
		} else {
			panier.put(produit, 1);
		}
		return list(request, response);
	}

	private RequestDispatcher remove(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Produit produit = produitRepository.findById(id).get();
		HttpSession session = request.getSession();
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");

		if (panier.get(produit) > 1) {
			panier.put(produit, panier.get(produit) - 1);
		} else {
			panier.remove(produit);
		}
		return list(request, response);
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		Personne client = personneRepository.findById(106).get();
		Commande commande = new Commande();
		commande.setDateCommande(LocalDate.now());
		commande.setClient(client);
		commandeRepository.save(commande);
		HttpSession session = request.getSession();
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		LigneCommande lc = null;
		for (Produit p : panier.keySet()) {
			lc = new LigneCommande();
			lc.setId(new LigneCommandePK(commande, p));
			lc.setQuantite(panier.get(p));
			ligneCommandeRepository.save(lc);
		}
		return request.getRequestDispatcher("/WEB-INF/commande/list.jsp");

	}
}
