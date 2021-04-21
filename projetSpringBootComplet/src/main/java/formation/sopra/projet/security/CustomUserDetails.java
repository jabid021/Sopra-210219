package formation.sopra.projet.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import formation.sopra.projet.entity.Personne;

public class CustomUserDetails implements UserDetails {

	private Personne personne;

	public CustomUserDetails(Personne personne) {
		this.personne = personne;
	}

	public Personne getPersonne() {
		return personne;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(personne.getRole().toString()));

	}

	@Override
	public String getPassword() {
		return personne.getPassword();
	}

	@Override
	public String getUsername() {
		return personne.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
