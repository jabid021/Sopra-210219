package formation.sopra.projet.clientRest.model;

public class Formateur {
	private Integer id;
	private String prenom;
	private String nom;
	
	public Formateur() {
		
	}

	public Formateur(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Formateur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	
	
	
}
