package metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//REQUIRED
@Entity
//OPTION
@Table(name="player")
//REQUIRED
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//OPTION
//@DiscriminatorColumn(name="poste",columnDefinition = "VARCHAR(3)")
public class Joueur {

	//REQUIRED
	@Id
	//~OPTION
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//OPTION
	@Column(name="identifiant")
	private int id;
	
	//OPTION
	@Column(name="name",columnDefinition = "VARCHAR(70)",nullable = false)
	private String nom;
	
	//OPTION
	@Column(name="firstname",nullable = false)
	private String prenom;
	
	//OPTION
	@Column(name="birthdate")
	private LocalDate naissance;
	
	@Enumerated(EnumType.STRING)
	private Poste poste;
	//REQUIRED
	
	@Embedded
	private Stats statistiques;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	private Equipe equipe;

	
	public Joueur() {
	}


	public Joueur(String nom, String prenom, String naissance,Poste poste) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = LocalDate.parse(naissance);
		this.poste=poste;
	}
	
	public Joueur(String nom, String prenom, String naissance,Poste poste,Stats statistiques) {
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = LocalDate.parse(naissance);
		this.poste=poste;
		this.statistiques=statistiques;
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

	

	public Poste getPoste() {
		return poste;
	}


	public void setPoste(Poste poste) {
		this.poste = poste;
	}


	public Stats getStatistiques() {
		return statistiques;
	}


	public void setStatistiques(Stats statistiques) {
		this.statistiques = statistiques;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", poste="
				+ poste + ", statistiques=" + statistiques + ", adresse=" + adresse + "]";
	}




	

	
	
	
	
	
}
