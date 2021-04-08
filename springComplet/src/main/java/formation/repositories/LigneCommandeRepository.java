package formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.LigneCommande;
import formation.entity.LigneCommandePK;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {

}
