package eshop.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAOProduit implements IDAOProduit {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit findById(Integer id) {
		Produit produit = em.find(Produit.class, id);
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		Query myQuery = em.createQuery("SELECT p from Produit p", Produit.class);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit save(Produit produit) {
		produit = em.merge(produit);
		return produit;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Produit produit) {
		produit = em.merge(produit);
		em.remove(produit);
	}

	@Override
	public List<Produit> findByLibelle(String libelleProduit) {
		Query query = em.createQuery("from Produit p where p.libelle = :lib", Produit.class);
		query.setParameter("lib", "%" + libelleProduit + "%");
		return query.getResultList();
	}

}
