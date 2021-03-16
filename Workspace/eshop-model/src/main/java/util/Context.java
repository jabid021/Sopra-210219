package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOClient;
import dao.IDAOFournisseur;
import dao.IDAOPersonne;
import dao.IDAOProduit;
import dao.jpa.DAOClient;
import dao.jpa.DAOFournisseur;
import dao.jpa.DAOPersonne;
import dao.jpa.DAOProduit;

public class Context {

	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopJPA");
	private static Context _instance=null;
	private IDAOClient daoClient = new DAOClient();
	private IDAOProduit daoProduit = new DAOProduit();
	private IDAOFournisseur daoFournisseur = new DAOFournisseur();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	
	private Context() 
	{}
	
	
	public static Context getInstance() 
	{
		if(_instance==null) {_instance=new Context();}
		return _instance;
	}
	
	
	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void closeEmf() 
	{
		emf.close();
	}


	public IDAOClient getDaoClient() {
		return daoClient;
	}


	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}


	public IDAOFournisseur getDaoFournisseur() {
		return daoFournisseur;
	}


	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}

	
}
