package demo.configjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import demo.xml.Instrument;

@Configuration
@ComponentScan({ "demo.configjava" })
@ImportResource("classpath:application-context.xml")
public class AppConfig {

	@Bean("piano")
	public Instrument piano() {
		return new Piano();
	}
}
