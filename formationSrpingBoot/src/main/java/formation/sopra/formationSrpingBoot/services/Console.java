package formation.sopra.formationSrpingBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import formation.sopra.formationSrpingBoot.repositories.FormateurRepository;

@Service
public class Console implements CommandLineRunner {

	@Autowired
	private FormateurRepository formateurRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(formateurRepository.findAll());
	}

}
