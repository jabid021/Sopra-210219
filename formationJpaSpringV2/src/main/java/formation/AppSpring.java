package formation;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import formation.entity.Commande;
import formation.entity.LigneCommande;
import formation.entity.LigneCommandePK;
import formation.entity.Personne;
import formation.entity.Produit;
import formation.repositories.CommandeRepository;
import formation.repositories.LigneCommandeRepository;
import formation.repositories.PersonneRepository;
import formation.repositories.ProduitRepository;

public class AppSpring {
	@Autowired
	private PersonneRepository personneRepo;

	@Autowired
	private CommandeRepository commandeRepo;

	@Autowired
	private ProduitRepository produitRepo;

	@Autowired
	private LigneCommandeRepository ligneCommandeRepo;

	public void run(String[] args) {

		Produit tele = new Produit();
		tele.setNom("tele");
		tele.setDescription("une grande tele");
		produitRepo.save(tele);
		personneRepo.save(new Personne("lolo", "lolo"));
		Personne p = new Personne("olivier", "gozlan");
		p = personneRepo.save(p);

		Commande commande1 = new Commande();
		commande1.setClient(p);
		commande1.setDateCommande(LocalDate.now());

		commandeRepo.save(commande1);

		LigneCommande lc = new LigneCommande();
		lc.setId(new LigneCommandePK(commande1, tele));
		lc.setQuantite(4);
		ligneCommandeRepo.save(lc);

		System.out.println(produitRepo.findByIdWithAllCommandes(tele.getId()).get().getLignesCommandes());

//		commandeRepo.findAll().stream().forEach(commande -> {
//			System.out.println(commande.getClient().getPrenom());
//		});
//
//		System.out.println("-------------------");
//		personneRepo.findWithCommandes().stream().forEach(client -> {
//			System.out.println(client.getPrenom());
//			System.out.println(client.getCommandes());
//		});
//
//		Optional<Personne> recherche = personneRepo.findByIdWithCommande(p.getId());
//		System.out.println(recherche.get().getCommandes());
//
//		System.out.println(personneRepo.findAll());
//		Optional<Personne> opt = personneRepo.findById(0);
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		} else {
//			System.out.println("pas de personne correspondante");
//		}
//		System.out.println("---------------------");
//		opt = personneRepo.findById(p.getId());
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		} else {
//			System.out.println("pas de personne correspondante");
//		}
//
//		personneRepo.save(new Personne("toto", "toto"));
//		personneRepo.save(new Personne("lulu", "lulu"));
//		personneRepo.save(new Personne("lolo", "lolo"));
//		System.out.println("---------------------");
//		System.out.println(personneRepo.findAll());
//		System.out.println("---------------------");
//		System.out.println(personneRepo.findAll(Sort.by("nom").descending().and(Sort.by("prenom"))));
//		System.out.println("---------------------");
//		Pageable page = PageRequest.of(0, 2, Sort.by("prenom"));
//		Page<Personne> result = personneRepo.findAll(page);
//		System.out.println(result.getContent());
//		System.out.println("---------------------");
//		System.out.println(personneRepo.findByPrenom("olivier"));
//		System.out.println("---------------------");
//		System.out.println(personneRepo.findByPrenomContaining("l"));
	}
}
