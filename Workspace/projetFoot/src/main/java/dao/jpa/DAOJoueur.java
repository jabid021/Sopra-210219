package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOJoueur;
import metier.Joueur;
import util.Context;

public class DAOJoueur implements IDAOJoueur {

	@Override
	public Joueur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Joueur joueur = em.find(Joueur.class, id);
		em.close();
		return joueur;
	}

	@Override
	public List<Joueur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joueur save(Joueur joueur) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		joueur=em.merge(joueur);
		
		em.getTransaction().commit();
		em.close();
		return joueur;
	}

	@Override
	public void delete(Joueur joueur) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		joueur=em.merge(joueur);
		em.remove(joueur);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
