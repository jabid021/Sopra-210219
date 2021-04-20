package formation.sopra.projet.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.projet.entity.Personne;
import formation.sopra.projet.repositories.PersonneRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private PersonneRepository personneRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Personne> opt = personneRepository.findByEmail(username);
		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		}
		throw new UsernameNotFoundException("utilisateur inconnu");
	}

}
