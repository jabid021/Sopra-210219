package eshop.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.dao.IDAOClient;
import eshop.model.Client;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAOClient implements IDAOClient {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Client findById(Integer id) {
		Client client = em.find(Client.class, id);
		return client;
	}

	@Override
	public List<Client> findAll() {
		Query myQuery = em.createQuery("SELECT c from Client c", Client.class);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Client save(Client client) {
		client = em.merge(client);
		return client;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Client client) {
		client = em.merge(client);
		em.remove(client);
	}

	@Override
	public List<Client> findAllWithAchat() {
		Query myQuery = em.createQuery("SELECT c from Client c join fetch c.produits ", Client.class);
		return myQuery.getResultList();
	}

}
