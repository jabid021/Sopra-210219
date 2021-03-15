package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

	@Id
	@Column(name="identifiant")
	private int id;
	@Column(name="name",columnDefinition = "VARCHAR(50)",nullable = false)
	@NotEmpty
	@Size(max=50)
	private String nom;
	
	@NotEmpty
	@Column(name="firstname",columnDefinition = "VARCHAR(50)",nullable = false)
	@Size(max=50)
	private String prenom;
	
	
	public Personne() {
	}
	
	public Personne(String nom,String prenom) {
		this.nom=nom;
		this.prenom=prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
