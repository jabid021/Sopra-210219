package formationJpaSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.AppSpring;
import formation.config.AppConfig;
import formation.dao.DaoPersonne;
import formation.entity.Personne;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}
}
