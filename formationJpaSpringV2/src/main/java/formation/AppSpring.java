package formation;

import org.springframework.beans.factory.annotation.Autowired;

import formation.dao.DaoPersonne;
import formation.entity.Personne;

public class AppSpring {
	@Autowired
	private DaoPersonne daoPersonne;

	public void run(String[] args) {
		Personne p = new Personne();
		p.setPrenom("olivier");
		p.setNom("gozlan");
		daoPersonne.insert(p);
	}
}
