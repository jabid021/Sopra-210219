package formation.sopra.projet.clientRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import formation.sopra.projet.clientRest.model.Formateur;

@Service
public class Console implements CommandLineRunner {

	private static final String FORMATION = "http://127.0.0.1:8080/formation";

	@Autowired
	private FormateurService formateurService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("client rest");
		// formateurService.getFormateur(100);
		// si pas de securite pour les webservices
		// restTemplate=new RestTemplate();
		formateurService.addFormateur(new Formateur("azerty", "azerty"));
		System.out.println(formateurService.getFormateurs());
	}

}
