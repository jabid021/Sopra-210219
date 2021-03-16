package dao;

import java.util.List;

import model.Client;

public interface IDAOClient extends IDAO<Client,Integer> {

	public List<Client> findAllWithAchat();
}
