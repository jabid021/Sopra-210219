package eshop.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.dao.IDAOFournisseur;
import eshop.model.Fournisseur;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAOFournisseur implements IDAOFournisseur {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Fournisseur findById(Integer id) {
		Fournisseur fournisseur = em.find(Fournisseur.class, id);
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() {
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Fournisseur save(Fournisseur fournisseur) {
		fournisseur = em.merge(fournisseur);
		return fournisseur;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Fournisseur fournisseur) {
		fournisseur = em.merge(fournisseur);
		em.remove(fournisseur);
	}

}
