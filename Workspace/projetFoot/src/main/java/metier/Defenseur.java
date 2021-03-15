package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
//REQUIRED
@Entity
//OPTION
@DiscriminatorValue("def")
//@PrimaryKeyJoinColumn(name="id_joueur",referencedColumnName = "identifiant") // referenced correspond au nom de la colonne id dans la table Joueur
public class Defenseur extends Joueur{

	
}
