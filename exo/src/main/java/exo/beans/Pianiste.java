package exo.beans;

import org.springframework.stereotype.Component;

@Component
public class Pianiste implements Musicien {

	private Instrument instrument;

	@Override
	public String jouer() {
		return "je suis un pianiste " + instrument;
	}

}
