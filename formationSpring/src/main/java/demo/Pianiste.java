package demo;

public class Pianiste implements Musicien {

	private Instrument instrument;

	protected Pianiste(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le pianiste joue " + instrument);
	}

}
