package formation.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client extends Personne {

	private int age;

	private LocalDate dateNaissance;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "achats", joinColumns = @JoinColumn(name = "id_client"), inverseJoinColumns = @JoinColumn(name = "id_produit"))
	private List<Produit> produits;

	// ===================== Constructeur
	public Client() {
	}

	public Client(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom, int age,
			String dateNaissance) {
		super(nom, prenom);
		this.age = age;
		this.dateNaissance = LocalDate.parse(dateNaissance);
	}

	public Client(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom, int version, int age,
			String dateNaissance, List<Produit> produits) {
		super(nom, prenom, version);
		this.age = age;
		this.dateNaissance = LocalDate.parse(dateNaissance);
		this.produits = produits;
	}

	// ===================== getters et setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = LocalDate.parse(dateNaissance);
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	// ===================== méthodes
	@Override
	public String toString() {
		return "Client [age=" + age + ", dateNaissance=" + dateNaissance + "]";
	}

}
