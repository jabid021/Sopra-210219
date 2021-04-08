package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eshop.AppSpring;
import eshop.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();

	}

}
