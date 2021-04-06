package demo;

public class Guitariste implements Musicien {
	private Instrument instrument;

	protected Guitariste(Instrument instrument) {
		this.instrument = instrument;
	}

	public void jouer() {
		System.out.println("le guitariste joue " + instrument);
	}
}
