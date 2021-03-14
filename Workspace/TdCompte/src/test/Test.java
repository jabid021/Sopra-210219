package test;

import java.util.Scanner;

import metier.Carte;
import metier.Compte;
import metier.Payant;
import metier.Premium;
import metier.Simple;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir votre carte");
		String saisie = sc.nextLine();
		
		
		
		
		Simple s1= new Simple(650, Carte.Visa);
		Payant p1 = new Payant(1500, Carte.MasterCard, -300);
		Payant p2 = new Payant(1500, Carte.MasterCard, 400);
		Premium pre= new Premium(10000,Carte.MasterCard);
		
		s1.retrait(291);
		s1.depot(1);
		
		p1.transfert(1600, s1);
		
		System.out.println("\nListe des comptes : \n---------------------------------------");

		for(Compte c : Compte.getBanque()) 
		{
			System.out.println(c);
		}
		
		
		System.out.println("---------------------------------------");
		
		
		System.out.println("Nombre de transaction : "+Compte.getNbTransac());
		System.out.println("Total des taxes : "+Compte.getTotalTaxe());
		System.out.println(Compte.getCpt());
		
		
		
		
		
		
		
	}

}
