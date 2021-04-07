package formationJpaSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formation.dao.DaoPersonne;
import formation.entity.Personne;

public class AppTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		DaoPersonne daoPersonne = ctx.getBean(DaoPersonne.class);
		Personne p = new Personne();
		p.setPrenom("olivier");
		p.setNom("gozlan");
		daoPersonne.insert(p);
		System.out.println(daoPersonne.findAll());
		ctx.close();
	}
}
