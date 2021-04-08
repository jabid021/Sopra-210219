package formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.ModuleFormation;
import formation.entity.ModuleFormationPK;

public interface ModuleFormationRepository extends JpaRepository<ModuleFormation, ModuleFormationPK> {

}
