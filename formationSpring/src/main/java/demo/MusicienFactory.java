package demo;

public class MusicienFactory {
	public static Musicien getMusicien() {
		return new Pianiste(InstrumentFactory.getInstrument());
	}

	public static Musicien getMusicien(String type) {
		return null;
	}

}
