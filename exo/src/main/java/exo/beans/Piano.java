package exo.beans;

import org.springframework.stereotype.Component;

@Component
public class Piano implements InstrumentClavier {

	@Override
	public String toString() {
		return "piano";
	}
}
