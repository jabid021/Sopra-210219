package formation.sopra.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.projet.entity.Personne;
import formation.sopra.projet.entity.Role;
import formation.sopra.projet.repositories.PersonneRepository;

@Service
public class Console implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	PersonneRepository personneRepo;

	@Override
	public void run(String... args) throws Exception {
		//initDataBase();
	}

	private void initDataBase() {
		Personne admin = new Personne();
		admin.setPrenom("admin");
		admin.setNom("admin");
		admin.setEmail("admin@ajc.fr");
		admin.setPassword(passwordEncoder.encode("admin"));
		admin.setRole(Role.ROLE_ADMIN);
		personneRepo.save(admin);

		Personne olivier = new Personne("olivier", "gozlan");
		olivier.setEmail("olivier@olivier.fr");
		olivier.setPassword(passwordEncoder.encode("olivier"));
		olivier.setRole(Role.ROLE_USER);
		personneRepo.save(olivier);
	}

}
