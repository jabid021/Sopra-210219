package metier;

public class Cercle extends Forme {

	private double rayon;
	
	public Cercle(double rayon) {
		super(0, 0, 0);
		this.rayon=rayon;
	}
	
	public double calculAir() {return Math.PI * rayon*rayon;}
	
	
	public double calculPerimetre() { return Math.PI *(rayon+rayon);}


	
	
	public void transfert(double montant, Compte destinataire) 
	{
		if(this.retraitOk(montant) && destinataire.depotOk(montant))
		{
			this.retrait(montant);
			destinataire.depot(montant);
		}
	}
	public void retrait(double montant) 
	{
		if(retraitOk()==true)
		{this.solde = this.solde - montant-taxe;}
	}
	
	
	public boolean retraitOk(double montant) {
		if(solde-montant-taxe>0)return true
				
	}
	public boolean retraitOk(double montant) {
		if(solde-montant-taxe+decouvert>0)return true
				
	}
	
	public boolean retraitOk(double montant) {
		return true
				
	}
	
}
