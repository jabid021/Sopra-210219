package exoAspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exoAspect.musique.Comique;
import exoAspect.musique.Musicien;

public class AppSpring {

	@Autowired
	@Qualifier("pianiste")
	private Musicien musicien;
	@Autowired
	private Comique c;

	public void run(String[] args) {
		c.faireSonShow();

		musicien.jouer();
	}
}
