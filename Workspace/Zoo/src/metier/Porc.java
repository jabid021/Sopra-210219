package metier;

public class Porc extends Animal implements Carnivore,Herbivore{

	@Override
	public void manger(String plante) {
		System.out.println("Je mange un(e) "+plante);
		
	}


	

}
