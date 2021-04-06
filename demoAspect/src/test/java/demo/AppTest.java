package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demoAspect.AppConfig;
import demoAspect.MonInterface;
import demoAspect.Personne;

public class AppTest {
	public static void main(String[] args) {
		// ClassPathXmlApplicationContext ctx = new
		// ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MonInterface personne = ctx.getBean(MonInterface.class);
		personne.display();
		ctx.close();

	}
}
