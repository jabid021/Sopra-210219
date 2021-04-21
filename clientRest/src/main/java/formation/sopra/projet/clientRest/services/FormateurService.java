package formation.sopra.projet.clientRest.services;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import formation.sopra.projet.clientRest.model.Formateur;

@Service
public class FormateurService {
	private static final String FORMATEUR = "http://127.0.0.1:8080/projet/api/formateur";
	private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder().basicAuthentication("toto", "toto");

	public Formateur getFormateur(Integer id) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		LinkedHashMap<String, Object> map = restTemplate.getForObject(FORMATEUR + "/" + id, LinkedHashMap.class);
		System.out.println(map);
		map.forEach((key, value) -> {
			System.out.println("key=" + key + " , value=" + value);
		});

		Formateur formateur = restTemplate.getForObject(FORMATEUR + "/" + id, Formateur.class);
		return formateur;
	}

	public List<Formateur> getFormateurs() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		Formateur[] formateurs = restTemplate.getForObject(FORMATEUR, Formateur[].class);
		return Arrays.asList(formateurs);
	}

	public Formateur addFormateur(Formateur formateur) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		return restTemplate.postForObject(FORMATEUR, formateur, Formateur.class);
	}

	public void updateFormateur(Formateur formateur) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.put(FORMATEUR + "/" + formateur.getId(), formateur);
	}

	public void updatePatch(Map<String, Object> map, Integer id) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.patchForObject(FORMATEUR + "/" + id, map, Formateur.class);

	}

	public void delete(Integer id) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.delete(FORMATEUR + "/" + id);
	}

}
