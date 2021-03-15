package metier;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="matchFoot")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate dateMatch;
	
	
	@ManyToMany
	private List<Equipe> equipes;
	
	public Match() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(LocalDate dateMatch) {
		this.dateMatch = dateMatch;
	}


	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", dateMatch=" + dateMatch + "]";
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
}
