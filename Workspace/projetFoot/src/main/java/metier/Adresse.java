package metier;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String libelle;
	
	public Adresse() {
	}

	@Override
	public String toString() {
		return "Adresse [libelle=" + libelle + "]";
	}
	
	
}
