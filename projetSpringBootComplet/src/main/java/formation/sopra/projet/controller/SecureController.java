package formation.sopra.projet.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.projet.entity.Commande;
import formation.sopra.projet.entity.Produit;
import formation.sopra.projet.security.CustomUserDetails;
import formation.sopra.projet.services.CommandeService;

@RequestMapping("/secure")
@Controller
public class SecureController {

	@Autowired
	private CommandeService commandeService;

	@GetMapping("/commande")
	public ModelAndView commande(HttpSession session, @AuthenticationPrincipal CustomUserDetails cUD) {
		ModelAndView modelAndView = new ModelAndView("secure/commande");
		modelAndView.addObject("personne", cUD.getPersonne());
		return modelAndView;
	}

	@GetMapping("/commande/save")
	public ModelAndView saveCommande(HttpSession session, @AuthenticationPrincipal CustomUserDetails cUD) {
		Commande commande = commandeService.save(cUD.getPersonne(),
				(Map<Produit, Integer>) session.getAttribute("panier"));
		session.removeAttribute("panier");
		return new ModelAndView("redirect:/public?commande=" + commande.getId());
	}
}
