package web.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import org.springframework.context.ApplicationContext;

import formation.entity.Personne;
import formation.repositories.PersonneRepository;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonneRepository personneRepository = null;
		RequestDispatcher rd = null;

		personneRepository = ((ApplicationContext) this.getServletContext().getAttribute("spring"))
				.getBean(PersonneRepository.class);

		String query = request.getParameter("query");
		if (query == null || query.isEmpty()) {
			// lister toute les personnes
			rd = goList(request, response, personneRepository);

		} else if (query.equals("delete")) {
			// supprimer une personne
			int id = Integer.parseInt(request.getParameter("id"));
			personneRepository.deleteById(id);
			rd = goList(request, response, personneRepository);
		} else if (query.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Optional<Personne> opt = personneRepository.findById(id);
			Personne personne = null;
			if (opt.isPresent()) {
				// edition
				personne = opt.get();
				rd = goEdit(request, response, personne);
			} else {
				rd = goEdit(request, response, new Personne());
			}

		} else if (query.equals("add")) {
			rd = goEdit(request, response, new Personne());
		} else if (query.equals("save")) {
			Integer id = null;
			if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			// int version = Integer.parseInt(request.getParameter("version"));
			Personne personne = null;
			if (id != null) {
				// update
				personne = personneRepository.findById(id).get();
			} else {
				// creation
				personne = new Personne();
			}
//			personne = new Personne();
//			personne.setId(id);
//			personne.setVersion(version);
			personne.setPrenom(prenom);
			personne.setNom(nom);
			personneRepository.save(personne);
			rd = goList(request, response, personneRepository);
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

	private RequestDispatcher goList(HttpServletRequest request, HttpServletResponse response,
			PersonneRepository personneRepository) {
		request.setAttribute("clients", personneRepository.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/client/list.jsp");
		return rd;
	}

	private RequestDispatcher goEdit(HttpServletRequest request, HttpServletResponse response, Personne personne) {
		request.setAttribute("personne", personne);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/client/edit.jsp");
		return rd;
	}

}
