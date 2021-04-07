package exoAspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import exoAspect.musique.Musicien;
import exoAspect.musique.Trompetiste;

@Configuration
@ComponentScan({ "exoAspect.dao", "exoAspect.aspect", "exoAspect.musique" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("trompetiste")
	public Musicien trompetiste() {
		return new Trompetiste();
	}
}
