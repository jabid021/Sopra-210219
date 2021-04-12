package web.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import formation.entity.Produit;
import formation.repositories.ProduitRepository;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProduitRepository produitRepository;

	@Override
	public void init() throws ServletException {
		produitRepository = ((ApplicationContext) this.getServletContext().getAttribute("spring"))
				.getBean(ProduitRepository.class);
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
			// liste des produits
			rd = list(request, response);
		} else if (query.equals("delete")) {
			rd = delete(request, response);
		} else if (query.equals("edit")) {
			rd = edit(request, response);
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/produit/list.jsp");
		request.setAttribute("produits", produitRepository.findAll());
		return rd;
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		produitRepository.deleteById(id);
		return list(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Optional<Produit> opt = produitRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(request, response, opt.get());
		}
		return goEdit(request, response, new Produit());
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		return goEdit(request, response, new Produit());
	}

	private RequestDispatcher goEdit(HttpServletRequest request, HttpServletResponse response, Produit produit) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/produit/edit.jsp");
		request.setAttribute("produit", produit);
		return rd;

	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		Integer id = null;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		Produit produit = new Produit();
		if (id != null) {
			produit = produitRepository.findById(id).get();
		}
		System.out.println(description);
		produit.setDescription(description);
		produit.setNom(nom);
		produitRepository.save(produit);
		return list(request, response);
	}

}
