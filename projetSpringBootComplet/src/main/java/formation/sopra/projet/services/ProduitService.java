package formation.sopra.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.projet.entity.Produit;
import formation.sopra.projet.exceptions.ProduitException;
import formation.sopra.projet.repositories.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepository;

	public List<Produit> getAllProduits() {
		return produitRepository.findAll();
	}

	public Produit getProduit(Integer id) throws ProduitException {
		Optional<Produit> opt = produitRepository.findById(id);
		if (opt.isEmpty()) {
			throw new ProduitException("id produit inconnu");
		}
		return opt.get();
	}

	public Produit save(Produit produit) {
		return produitRepository.save(produit);
	}

	public void delete(Integer id) {
		produitRepository.deleteById(id);
	}
}
