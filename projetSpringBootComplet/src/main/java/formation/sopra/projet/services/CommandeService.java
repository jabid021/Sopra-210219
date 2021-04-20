package formation.sopra.projet.services;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.projet.entity.Commande;
import formation.sopra.projet.entity.LigneCommande;
import formation.sopra.projet.entity.LigneCommandePK;
import formation.sopra.projet.entity.Personne;
import formation.sopra.projet.entity.Produit;
import formation.sopra.projet.repositories.CommandeRepository;
import formation.sopra.projet.repositories.LigneCommandeRepository;
import formation.sopra.projet.repositories.PersonneRepository;
import formation.sopra.projet.repositories.ProduitRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	public Commande save(Personne personne, Map<Produit, Integer> panier) {
		Commande commande = new Commande();
		commande.setDateCommande(LocalDate.now());
		commande.setClient(personne);
		commandeRepository.save(commande);
		LigneCommande lc = null;
		for (Produit p : panier.keySet()) {
			lc = new LigneCommande();
			lc.setId(new LigneCommandePK(commande, p));
			lc.setQuantite(panier.get(p));
			ligneCommandeRepository.save(lc);
		}
		return commande;
	}
}
