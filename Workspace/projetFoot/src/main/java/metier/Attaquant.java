package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//REQUIRED
@Entity
//OPTION
@DiscriminatorValue("att")
public class Attaquant extends Joueur {

}
