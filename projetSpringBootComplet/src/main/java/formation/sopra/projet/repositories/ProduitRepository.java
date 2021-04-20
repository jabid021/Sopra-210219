package formation.sopra.projet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.projet.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	@Query("select p from Produit p left join fetch p.lignesCommandes lc left join fetch lc.id.commande where p.id=:id")
	Optional<Produit> findByIdWithAllCommandes(@Param("id") Integer id);
}
