package formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
