package formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Integer> {
	
}
