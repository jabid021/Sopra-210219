package dao;

import java.util.List;

import model.Produit;

public interface IDAOProduit extends IDAO<Produit,Integer> {

	public List<Produit> findByLibelle(String lib);
	
}
