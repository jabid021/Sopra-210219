package demo.configjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import demo.xml.Musicien;

public class Principal {

	@Autowired
	@Qualifier("hendrix")
	private Musicien musicien;

	public void run(String[] args) {
		musicien.jouer();
	}
}
