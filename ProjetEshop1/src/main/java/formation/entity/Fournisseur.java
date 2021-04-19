package formation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fournisseur")
public class Fournisseur extends Personne {

	@Column(name = "company")
	private String societe;

	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> produits;

	// ===================== Constructeur
	public Fournisseur() {
	}

	public Fournisseur(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom, String societe) {
		super(nom, prenom);
		this.societe = societe;
	}

	public Fournisseur(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom, int version,
			String societe) {
		super(nom, prenom, version);
		this.societe = societe;
	}

	public Fournisseur(@NotEmpty @Size(max = 50) String nom, @NotEmpty @Size(max = 50) String prenom, int version,
			String societe, List<Produit> produits) {
		super(nom, prenom, version);
		this.societe = societe;
		this.produits = produits;
	}

	// ===================== getters et setters
	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Fournisseur [societe=" + societe + ", produits=" + produits + "]";
	}

}
