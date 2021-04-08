package eshop.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.dao.IDAOPersonne;
import eshop.model.Personne;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAOPersonne implements IDAOPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne findById(Integer id) {
		Personne personne = em.find(Personne.class, id);
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne save(Personne personne) {
		personne = em.merge(personne);
		return personne;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Personne personne) {
		personne = em.merge(personne);
		em.remove(personne);
	}

}
