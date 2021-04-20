package formation.sopra.projet.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.projet.entity.Commande;
import formation.sopra.projet.entity.LigneCommande;
import formation.sopra.projet.entity.LigneCommandePK;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {

	@Query("delete from LigneCommande lc where lc.id.commande=:commande")
	@Transactional
	@Modifying
	void deleteByCommande(@Param("commande") Commande commande);
}
