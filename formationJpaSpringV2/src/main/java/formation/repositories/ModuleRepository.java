package formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
	
}
