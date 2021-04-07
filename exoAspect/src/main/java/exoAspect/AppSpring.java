package exoAspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exoAspect.musique.Musicien;

public class AppSpring {

	@Autowired
	@Qualifier("pianiste")
	private Musicien musicien;

	public void run(String[] args) {
		musicien.jouer();
	}
}
