package exo.beans;

import org.springframework.stereotype.Component;

@Component
public class GuitareElectrique implements InstrumentACorde {
	@Override
	public String toString() {
		return "guitare electrique";
	}
}
