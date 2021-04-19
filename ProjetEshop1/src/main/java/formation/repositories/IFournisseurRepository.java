package formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Integer>{
	
	List<Fournisseur> findByPrenom(String prenom);

	List<Fournisseur> findByPrenomContaining(String prenom);

	List<Fournisseur> findByPrenomAndNom(String prenom, String nom);

}
