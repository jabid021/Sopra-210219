package test;

import java.util.List;
import java.util.Scanner;

import model.Client;
import model.Fournisseur;
import model.Produit;
import util.Context;

public class Test {

	public static void main(String[] args) {
		
		
		
		Produit p1 = new Produit();
		p1.setLibelle("stylo bic");
		p1.setPrix(3);
		
		Produit p2 = new Produit();
		p2.setLibelle("stylo plume");
		p2.setPrix(4);
		
		
		
		Client c1 = new Client("Abid", "Jordan", 27, "1993-05-01");
		
		
		Fournisseur bic = new Fournisseur("Doe", "John", "BIC");
		//bic=Context.getInstance().getDaoFournisseur().save(bic);
		
		p1.setFournisseur(bic);
		//p1=Context.getInstance().getDaoProduit().save(p1);
		
		//bic=Context.getInstance().getDaoFournisseur().findById(1);

		
		
	//	p2=Context.getInstance().getDaoProduit().save(p2);
		
		
		c1.getProduits().add(p1);
		
		
		
		
		//Context.getInstance().getDaoClient().save(c1);
		
		
		List<Client> clientsDuSite = Context.getInstance().getDaoClient().findAllWithAchat();
		System.out.println("SELECT ALL");
		for(Client c : clientsDuSite) 
		{
			System.out.println(c);
			System.out.println("AFFICHER LES PRODUITS : ");
			System.out.println(c.getProduits());
		}

		
		
	}

}
