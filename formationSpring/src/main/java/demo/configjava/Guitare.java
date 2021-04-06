package demo.configjava;

import org.springframework.stereotype.Component;

import demo.xml.Instrument;

@Component("guitare")
public class Guitare implements Instrument {

	public Guitare() {

	}

	public String toString() {
		return "gling gling gling";
	}
}
