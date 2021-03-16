package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOFournisseur;
import model.Fournisseur;
import util.Context;

public class DAOFournisseur implements IDAOFournisseur {

	@Override
	public Fournisseur findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Fournisseur fournisseur = em.find(Fournisseur.class, id);
		em.close();
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur save(Fournisseur fournisseur) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		fournisseur=em.merge(fournisseur);
		
		em.getTransaction().commit();
		em.close();
		return fournisseur;
	}

	@Override
	public void delete(Fournisseur fournisseur) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		fournisseur=em.merge(fournisseur);
		em.remove(fournisseur);
		
		em.getTransaction().commit();
		em.close();
		
	}


}
