package formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.entity.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer>{
	
	List<Produit> findByLibelle(String libelle);
	
//	@Query("select p "
//			+ "from Produit p "
//			+ "left join fetch p.fournisseur f "
//			+ "where f.fournisseur.nom=:nomFournisseur")
//	List<Produit> findByFournisseur(@Param("nomFournisseur") String nomFournisseur);

}
