package exo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exo.config.AppConfig;

public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(Principal.class).run(args);
		ctx.close();

	}

}
