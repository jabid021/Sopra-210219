package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.Joueur;
import metier.Poste;
import metier.Stats;

public class Test {

	public static void main(String[] args) {
		
		Stats s = new Stats(88,92,94);
		s.setId(1);
		
		Joueur j= new Joueur("Abid","Jordan","1993-05-01",Poste.DD,s);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("baseFoot");
		EntityManager em = emf.createEntityManager();
		
		/*em.getTransaction().begin();
		
		
		em.persist(j);
		
		
		em.getTransaction().commit();
		
		
		System.out.println(em.find(Joueur.class, 1));
		
		*/
		
		em.close();
		emf.close();

	}

}
