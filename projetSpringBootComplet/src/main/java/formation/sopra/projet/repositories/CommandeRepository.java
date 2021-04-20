package formation.sopra.projet.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.projet.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	@Query("delete from Commande c where c.client.id=:id")
	@Transactional
	@Modifying
	public void deleteByClientId(@Param("id") Integer id);

}
