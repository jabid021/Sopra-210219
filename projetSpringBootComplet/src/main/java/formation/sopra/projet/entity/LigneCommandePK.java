package formation.sopra.projet.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneCommandePK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_commande", foreignKey = @ForeignKey(name = "ligne_commande_id_commande_fk"))
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "id_produit", foreignKey = @ForeignKey(name = "ligne_commande_id_produit_fk"))
	private Produit produit;

	public LigneCommandePK() {

	}

	public LigneCommandePK(Commande commande, Produit produit) {
		super();
		this.commande = commande;
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
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
		LigneCommandePK other = (LigneCommandePK) obj;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		return true;
	}

}
