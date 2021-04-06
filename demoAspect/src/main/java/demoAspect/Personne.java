package demoAspect;

public class Personne implements MonInterface {
	private String prenom = "olivier";
	private String nom = "gozlan";

	public Personne() {

	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + "]";
	}

	public String display() {
		// throw new IllegalArgumentException();
		return this.toString();
	}

	public void methodeExecuteDansLeBeforeDeLAspect() {
		System.out.println("appel par le before");
	}

}
