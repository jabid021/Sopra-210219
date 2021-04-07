package formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formation.entity.Personne;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoPersonneJpaSpringImpl implements DaoPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Personne obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne update(Personne obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Personne obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteById(Integer id) {
		em.remove(em.find(Personne.class, id));
	}

	@Override
	public Personne findById(Integer id) {
		return em.find(Personne.class, id);
	}

	@Override
	public List<Personne> findAll() {
		return em.createQuery("select p from Personne p", Personne.class).getResultList();
	}

}
