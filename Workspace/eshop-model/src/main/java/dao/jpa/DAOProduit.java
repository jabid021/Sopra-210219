package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOProduit;
import model.Produit;
import util.Context;

public class DAOProduit implements IDAOProduit {

	@Override
	public Produit findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Produit produit = em.find(Produit.class, id);
		em.close();
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT p from Produit p",Produit.class);
		 return myQuery.getResultList(); 
	}

	@Override
	public Produit save(Produit produit) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		produit=em.merge(produit);
		
		em.getTransaction().commit();
		em.close();
		return produit;
	}

	@Override
	public void delete(Produit produit) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		produit=em.merge(produit);
		em.remove(produit);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Produit> findByLibelle(String libelleProduit) 
	{ 
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Query query = em.createQuery("from Produit p where p.libelle = :lib", Produit.class); 
		query.setParameter("lib", "%"+libelleProduit+"%");
		//getSingleResult si un seul element
	return  query.getResultList(); 
	}


}
