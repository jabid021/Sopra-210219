package formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Integer> {

}
