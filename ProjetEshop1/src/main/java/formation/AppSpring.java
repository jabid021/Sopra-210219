package formation;

import org.springframework.beans.factory.annotation.Autowired;

import formation.entity.Client;
import formation.entity.Fournisseur;
import formation.entity.Produit;
import formation.repositories.IClientRepository;
import formation.repositories.IFournisseurRepository;
import formation.repositories.IProduitRepository;

public class AppSpring {
	
	@Autowired
	private IClientRepository IClientRepo;
	
	@Autowired
	private IFournisseurRepository IFournisseurRepo;
	
	@Autowired
	private IProduitRepository IProduitRepo;

	public void run(String[] args) {

	}
}
