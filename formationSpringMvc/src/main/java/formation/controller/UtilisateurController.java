package formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.model.Utilisateur;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public UtilisateurController() {
		System.out.println("constructeur utilisateurController");
	}

	@GetMapping({ "", "/" })
	public String hello(Model model, @RequestParam String prenom, @RequestParam String nom) {
		model.addAttribute("utilisateur", new Utilisateur(prenom, nom));
		return "utilisateur/hello";
	}

	@GetMapping("/objet")
	public String helloAvecObject(Model model, @ModelAttribute Utilisateur utilisateur) {
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateur/hello";
	}

}
