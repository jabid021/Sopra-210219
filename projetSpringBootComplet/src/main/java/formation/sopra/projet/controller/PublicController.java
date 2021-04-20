package formation.sopra.projet.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.projet.entity.Personne;
import formation.sopra.projet.entity.Produit;
import formation.sopra.projet.entity.Role;
import formation.sopra.projet.exceptions.PersonneException;
import formation.sopra.projet.exceptions.ProduitException;
import formation.sopra.projet.security.CustomUserDetails;
import formation.sopra.projet.services.PersonneService;
import formation.sopra.projet.services.ProduitService;

@Controller
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private PersonneService personneService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping({ "", "/" })
	public ModelAndView index(Authentication authentication) {
		ModelAndView modelAndView = new ModelAndView("public/index");
		if (authentication != null) {
			Personne personne = ((CustomUserDetails) authentication.getPrincipal()).getPersonne();
			try {
				personne = personneService.getWithCommande(personne.getId());
				modelAndView.addObject("personne", personne);
			} catch (PersonneException e) {
				e.printStackTrace();
			}
		}
		return modelAndView;
	}

	@GetMapping("/produit")
	public ModelAndView listProduit() {
		ModelAndView modelAndView = new ModelAndView("produit/list");
		modelAndView.addObject("produits", produitService.getAllProduits());
		return modelAndView;
	}

	@GetMapping("/panier/add")
	public ModelAndView addPanier(@RequestParam Integer id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Produit produit = null;
		try {
			produit = produitService.getProduit(id);
			if (session.getAttribute("panier") == null) {
				session.setAttribute("panier", new HashMap<Produit, Integer>());
			}
			Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
			if (panier.containsKey(produit)) {
				panier.put(produit, panier.get(produit) + 1);
			} else {
				panier.put(produit, 1);
			}
			modelAndView.setViewName("redirect:/public/produit?success=");
		} catch (ProduitException ex) {
			modelAndView.setViewName("redirect:/public/produit?error=");
		}
		return modelAndView;
	}

	@GetMapping("/panier/remove")
	public ModelAndView removePanier(@RequestParam Integer id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Produit produit = null;
		try {
			produit = produitService.getProduit(id);
			Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");

			if (panier.get(produit) > 1) {
				panier.put(produit, panier.get(produit) - 1);
			} else {
				panier.remove(produit);
			}
			modelAndView.setViewName("redirect:/public/produit?remove=");
		} catch (ProduitException ex) {
			modelAndView.setViewName("redirect:/public/produit?error=");
		}
		return modelAndView;
	}

	@GetMapping("/panier/save")
	public ModelAndView savePanier(@AuthenticationPrincipal CustomUserDetails cUD) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(cUD);
		modelAndView.setViewName("/public");
		return modelAndView;
	}

	@GetMapping("/inscription")
	public ModelAndView inscription(@RequestParam(name = "source", required = false, defaultValue = "") String source) {
		return goInscription(new Personne(), "", source);
	}

	private ModelAndView goInscription(Personne personne, String confirme, String source) {
		ModelAndView modelAndView = new ModelAndView("public/inscription");
		modelAndView.addObject("personne", personne);
		modelAndView.addObject("confirm", confirme);
		modelAndView.addObject("source", source);
		return modelAndView;
	}

	@PostMapping("/inscription")
	public ModelAndView inscription(@Valid @ModelAttribute Personne personne, BindingResult br,
			@RequestParam String confirm, @RequestParam String source) {
		if (!personne.getPassword().equals(confirm)) {
			br.addError(new ObjectError("password", "les mots de passes ne sont pas egaux"));
		}
		if (br.hasErrors()) {
			return goInscription(personne, confirm, source);
		}
		personne.setPassword(passwordEncoder.encode(personne.getPassword()));
		personne.setRole(Role.ROLE_USER);
		personneService.save(personne);
		if (source.equals("panier")) {
			return new ModelAndView("redirect:/secure/commande");
		}
		return new ModelAndView("redirect:/public?inscription");
	}

}
