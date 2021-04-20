package formation.sopra.projet.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.projet.entity.Commande;
import formation.sopra.projet.entity.Personne;
import formation.sopra.projet.entity.Produit;
import formation.sopra.projet.exceptions.ProduitException;
import formation.sopra.projet.security.CustomUserDetails;
import formation.sopra.projet.services.CommandeService;
import formation.sopra.projet.services.PersonneService;
import formation.sopra.projet.services.ProduitService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ProduitService produitService;
	@Autowired
	CommandeService commandeService;
	@Autowired
	PersonneService personneService;

	@GetMapping("/produit/edit")
	public ModelAndView editProduit(@RequestParam Integer id) {
		Produit p = null;
		try {
			p = produitService.getProduit(id);
		} catch (ProduitException e) {
		}
		return goEditProduit(p);
	}

	@GetMapping("/produit/add")
	public ModelAndView addProduit() {
		return goEditProduit(new Produit());
	}

	private ModelAndView goEditProduit(Produit produit) {
		ModelAndView modelAndView = new ModelAndView("produit/edit");
		modelAndView.addObject("produit", produit);
		return modelAndView;
	}

	@PostMapping("/produit/save")
	public ModelAndView saveProduit(@Valid @ModelAttribute Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			return goEditProduit(produit);
		}
		produitService.save(produit);
		return new ModelAndView("redirect:/public/produit?edit=");
	}

	@GetMapping("/produit/delete")
	public ModelAndView deleteProduit(@RequestParam Integer id) {
		produitService.delete(id);
		return new ModelAndView("redirect:/public/produit?delete=");
	}

	@GetMapping("/commande/save")
	public ModelAndView saveCommande(@AuthenticationPrincipal CustomUserDetails cUD, HttpSession session) {
		if (session.getAttribute("panier") == null) {
			return new ModelAndView("redirect:/public/produit?panier=");
		}
		Commande commande = commandeService.save(cUD.getPersonne(),
				(Map<Produit, Integer>) session.getAttribute("panier"));
		session.removeAttribute("panier");
		return new ModelAndView("redirect:/public?commande=");
	}

	@GetMapping("/personne")
	public ModelAndView getPersonnes() {
		ModelAndView modelAndView = new ModelAndView("personne/list");
		modelAndView.addObject("personnes", personneService.getAll());
		return modelAndView;
	}

	@GetMapping("/personne/delete")
	public ModelAndView deletePersonne(@RequestParam Integer id) {
		personneService.delete(id);
		return new ModelAndView("redirect:/admin/personne?delete=" + id);
	}

}
