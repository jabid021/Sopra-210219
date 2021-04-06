package demoAspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("demoAspect")
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("olivier")
	public MonInterface personne() {
		return new Personne();
	}
}
