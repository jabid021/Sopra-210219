package test;

import metier.Equipe;
import metier.Joueur;
import metier.Poste;
import metier.Stats;
import util.Context;

public class Test {

	public static void main(String[] args) {
		
		
		Joueur joueur1 = new Joueur("Abid","Jordan","1993-05-01",Poste.AD,new Stats(70,68,80));
		joueur1.setEquipe(new Equipe());
		
		
		joueur1=Context.getInstance().getDaoJoueur().save(joueur1);
		
		joueur1.setNaissance("1993-05-02");
		Context.getInstance().getDaoJoueur().save(joueur1);
		
		Joueur j2=Context.getInstance().getDaoJoueur().findById(8);
		
		
		Context.getInstance().getDaoJoueur().delete(j2);

		
	
		Context.getInstance().closeEmf();

	}

}
//Managed, soit detached/transient

		//SelectOne -> em.find(Class,id) => Managed
		//SelectAll => ? => Not Managed
		/*
		 * Update-> em.merge(object) => ~Managed
		 * insert- em.persist(object) => Managed
		 * delete em.remove(object) => Deleted
		
		em.getTransaction().begin();
		em.persist(j2);//j => managed
		//Joueur jManaged=em.merge(j);//j => pas managed par contre jManaged l'est !  => Equivalent de j=em.merge(j)
	
		em.getTransaction().commit();
		 */
		