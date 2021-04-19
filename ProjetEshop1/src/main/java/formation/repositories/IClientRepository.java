package formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Integer>{
	
	List<Client> findByPrenom(String prenom);

	List<Client> findByPrenomContaining(String prenom);

	List<Client> findByPrenomAndNom(String prenom, String nom);
	
}
