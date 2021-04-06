package exo.beans;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

public class Guitariste implements Musicien {

	private Instrument instrument;

	public Guitariste() {
		System.out.println("dans le constructeur " + instrument);
	}

	@PostConstruct
	public void init() {
		System.out.println("dans postconstruct " + instrument);
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public String jouer() {
		return "je suis un guitariste " + instrument;
	}

}
