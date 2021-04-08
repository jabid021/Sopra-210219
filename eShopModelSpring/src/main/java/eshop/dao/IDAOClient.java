package eshop.dao;

import java.util.List;

import eshop.model.Client;

public interface IDAOClient extends IDAO<Client,Integer> {

	public List<Client> findAllWithAchat();
}
