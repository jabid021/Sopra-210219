package metier;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Embeddable
public class Stats {


	private int vitesse;
	private int attaque;
	private int defense;
	
	public Stats() {
	}

	public Stats (int vitesse, int attaque, int defense) {
		this.vitesse = vitesse;
		this.attaque = attaque;
		this.defense = defense;
	}


	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	@Override
	public String toString() {
		return "Stats [vitesse=" + vitesse + ", attaque=" + attaque + ", defense=" + defense + "]";
	}

	
	
	
	
}
