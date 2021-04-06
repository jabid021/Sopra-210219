package exo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exo.beans.Musicien;

public class Principal {

//	@Autowired
//	private Guitariste guitaristeAvecGuitareElectrique;
//	@Autowired
//	private Guitariste guitaristeAvecGuitareClassique;
//	@Autowired
//	private Pianiste pianoAvecClassique;
//	@Autowired
//	private Pianiste pianisteAvecSynthe;

	@Autowired
	@Qualifier("guitaristeE")
	private Musicien guitaristeE;
	@Autowired
	@Qualifier("guitaristeC")
	private Musicien guitaristeC;

	public void run(String[] args) {
		System.out.println(guitaristeC.jouer());
	}
}
