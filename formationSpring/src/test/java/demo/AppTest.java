package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.configjava.AppConfig;
import demo.configjava.Principal;
import demo.xml.Instrument;
import demo.xml.Musicien;

public class AppTest {
	public static void main(String[] args) {
		// ClassPathXmlApplicationContext ctx = new
		// ClassPathXmlApplicationContext("application-context.xml");
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//		Musicien musicien = ctx.getBean("hendrix", Musicien.class);
//		musicien.jouer();
//
//		System.out.println(ctx.getBean("piano", Instrument.class));
//		ctx.close();

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(Principal.class).run(args);
		ctx.close();
	}
}
