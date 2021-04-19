package formation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_personne", initialValue = 1, allocationSize = 1)
@Table(name = "personne")
public abstract class Personne {

	@Id
	@Column(name = "identifiant")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	private int id;

	@NotEmpty
	@Column(name = "nom", columnDefinition = "VARCHAR(50)", nullable = false)
	@Size(max = 50)
	private String nom;

	@NotEmpty
	@Column(name = "prenom", columnDefinition = "VARCHAR(50)", nullable = false)
	@Size(max = 50)
	private String prenom;

	@Version
	private int version;

	// ===================== Constructeur
	public Personne() {
	}

	public Personne(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom, int version) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.version = version;
	}

	// ===================== getters et setters
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	//===================== méthodes
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
