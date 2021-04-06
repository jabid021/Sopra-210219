package exo.beans;

import org.springframework.stereotype.Component;

@Component
public class GuitareClassique implements InstrumentACorde {

	@Override
	public String toString() {
		return "guitare classique";
	}
}
