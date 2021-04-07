package exoAspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({ "exoAspect.dao", "exoAspect.aspect" })
@EnableAspectJAutoProxy
public class AppConfig {

}
