package formation.sopra.projet.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.projet.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
	List<Personne> findByPrenom(String prenom);

	List<Personne> findByPrenomContaining(String prenom);

	List<Personne> findByPrenomAndNom(String prenom, String nom);

	@Query("select p from Personne p left join fetch p.commandes")
	List<Personne> findWithCommandes();

	@Query("select p from Personne p left join fetch p.commandes where p.id=:id")
	Optional<Personne> findByIdWithCommande(@Param("id") Integer id);

	Optional<Personne> findByEmail(String email);

	@Query("select p from Personne p where p.role='ROLE_USER'")
	List<Personne> findAllUser();
}
