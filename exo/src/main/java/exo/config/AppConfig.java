package exo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import exo.beans.GuitareClassique;
import exo.beans.GuitareElectrique;
import exo.beans.Guitariste;
import exo.beans.Musicien;

@Configuration
@ComponentScan("exo.beans")
public class AppConfig {

	@Bean("guitaristeE")
	public Musicien guitaristeAvecGuitareElectrique(GuitareElectrique guitare) {
		Guitariste musicien = new Guitariste();
		musicien.setInstrument(guitare);
		return musicien;
	}

	@Bean("guitaristeC")
	public Musicien guitaristeAvecGuitareClassique(GuitareClassique guitare) {
		Guitariste musicien = new Guitariste();
		musicien.setInstrument(guitare);
		return musicien;
	}
}
