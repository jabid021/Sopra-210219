package metier;

public enum Plat {
	Pizza(8.5),Pate(4.5),Burger(5.5),Poisson(4.8), FishAndChips(7.6);
	
	private double prix;

	private Plat(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}
	
	
	
	
	
}
