package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipe")
	private int id;
	private String nom;
	
	@OneToOne
	@JoinColumn(name="capitaine")
	private Joueur capitaine;
	
	@OneToMany(mappedBy = "equipe")
	private List<Joueur> joueurs;

	@ManyToMany(mappedBy="equipes")
	List<Match> matchs;
	
	public Equipe() {
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

	public Joueur getCapitaine() {
		return capitaine;
	}

	public void setCapitaine(Joueur capitaine) {
		this.capitaine = capitaine;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nom=" + nom + ", capitaine=" + capitaine + "]";
	}
	
	
	
	
	
}
