package demo.xml;

public class Pianiste implements Musicien {

	private Instrument instrument;

	public Pianiste() {

	}

	protected Pianiste(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le pianiste joue " + instrument);
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
