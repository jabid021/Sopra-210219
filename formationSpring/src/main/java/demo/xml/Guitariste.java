package demo.xml;

public class Guitariste implements Musicien {
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
