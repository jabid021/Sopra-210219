package metier;

public enum Boisson {

	Vin(5),Biere(4),Whisky(8),Champagne(10),Coca(2),Limonade(2),Oasis(2);
	
	private double prix;

	private Boisson(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}
	
	
	
	
	
}
