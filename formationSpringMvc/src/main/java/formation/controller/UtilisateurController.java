package formation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.model.Utilisateur;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>(
			Arrays.asList(new Utilisateur("user1", "user1"), new Utilisateur("user2", "user2")));

	public UtilisateurController() {
		System.out.println("constructeur utilisateurController");
	}

//	@GetMapping({ "", "/" })
//	public String hello(Model model, @RequestParam String prenom, @RequestParam String nom) {
//		model.addAttribute("utilisateur", new Utilisateur(prenom, nom));
//		return "utilisateur/hello";
//	}

	@GetMapping("/objet")
	public String helloAvecObject(Model model, @ModelAttribute Utilisateur utilisateur) {
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateur/hello";
	}

	@GetMapping({ "", "/" })
	public String list(Model model) {
		model.addAttribute("utilisateurs", utilisateurs);
		return "utilisateur/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Utilisateur(), null, model);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer index) {
		utilisateurs.remove(index.intValue());
		return "redirect:/utilisateur";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer index, Model model) {
		return goEdit(utilisateurs.get(index), index, model);
	}

	private String goEdit(Utilisateur utilisateur, Integer index, Model model) {
		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("index", index);
		return "utilisateur/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Utilisateur utilisateur,
			@RequestParam(name = "index", required = false) Integer index) {
		if (index != null) {
			utilisateurs.remove(index.intValue());
			utilisateurs.add(index, utilisateur);
		} else {
			utilisateurs.add(utilisateur);
		}
		return "redirect:/utilisateur";
	}

}
