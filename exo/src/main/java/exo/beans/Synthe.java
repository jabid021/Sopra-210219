package exo.beans;

import org.springframework.stereotype.Component;

@Component
public class Synthe implements InstrumentClavier {
	@Override
	public String toString() {
		return "synthe";
	}
}
