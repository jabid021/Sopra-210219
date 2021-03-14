package metier;

public interface Carnivore {


	public default void manger(Animal a) 
	{
		System.out.println("Je mange un "+a.getClass().getSimpleName());
	}
}
