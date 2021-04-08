package formation;

import org.springframework.beans.factory.annotation.Autowired;

import formation.repositories.FormationRepository;
import formation.repositories.ModuleFormationRepository;
import formation.repositories.FormateurRepository;
import formation.repositories.ModuleRepository;

public class AppSpring {
	@Autowired
	private FormateurRepository formateurRepository;

	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ModuleFormationRepository moduleFormationRepository;

	public void run(String[] args) {

		
	}
}
