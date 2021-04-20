package formation.sopra.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.projet.entity.Personne;
import formation.sopra.projet.exceptions.PersonneException;
import formation.sopra.projet.repositories.CommandeRepository;
import formation.sopra.projet.repositories.LigneCommandeRepository;
import formation.sopra.projet.repositories.PersonneRepository;

@Service
public class PersonneService {

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;

	public Personne save(Personne personne) {
		return personneRepository.save(personne);
	}

	public Personne getWithCommande(Integer id) throws PersonneException {
		Optional<Personne> opt = personneRepository.findByIdWithCommande(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new PersonneException("identifiant personne inconnu");
	}

	public List<Personne> getAll() {
		return personneRepository.findAllUser();
	}

	public void delete(Personne personne) {
		delete(personne.getId());
	}

	public void delete(Integer id) {
		Optional<Personne> opt = personneRepository.findByIdWithCommande(id);
		if (opt.isPresent()) {
			Personne personne = opt.get();
			personne.getCommandes().stream().forEach(commande -> {
				ligneCommandeRepository.deleteByCommande(commande);
				commandeRepository.deleteByClientId(personne.getId());
			});
			personneRepository.delete(personne);
		}
	}
}
