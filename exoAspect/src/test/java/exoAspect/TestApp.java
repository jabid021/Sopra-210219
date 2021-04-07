package exoAspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoAspect.config.AppConfig;

public class TestApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}
}
