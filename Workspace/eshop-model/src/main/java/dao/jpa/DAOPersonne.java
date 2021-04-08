package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOPersonne;
import model.Personne;
import util.Context;

public class DAOPersonne implements IDAOPersonne {

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class, id);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		personne=em.merge(personne);
		
	
		em.getTransaction().commit();
		em.close();
		return personne;
	}

	@Override
	public void delete(Personne personne) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		personne=em.merge(personne);
		em.remove(personne);
		
		em.getTransaction().commit();
		em.close();
		
	}


}
