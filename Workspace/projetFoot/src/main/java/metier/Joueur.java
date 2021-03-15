package metier;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Joueur {

	
	@Id
	private int id;
	private String nom;
	private String prenom;
	private LocalDate naissance;
	
	
	public Joueur() {
	}


	public Joueur(String nom, String prenom, String naissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = LocalDate.parse(naissance);
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


	public LocalDate getNaissance() {
		return naissance;
	}


	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}


	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + "]";
	}
	
	
	
	
	
}
