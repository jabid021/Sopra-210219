package demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import demo.xml.Instrument;
import demo.xml.Musicien;

@Component("hendrix")
public class Guitariste implements Musicien {
	@Autowired
	@Qualifier("piano")
	private Instrument instrument;

	public Guitariste() {

	}

	public void jouer() {
		System.out.println("le guitariste joue " + instrument);
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
