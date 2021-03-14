import java.util.Arrays;
import java.util.Scanner;

public class Test {
	
	
	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}

	public static double saisieDouble(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}

	public static int saisieInt(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}


	public static void tp1_2() 
	{
		int min=20;
		int max=10;
		int tmp=min;
		min=max;
		max=tmp;

		
		System.out.print("min vaut "+min+" et max vaut "+max) ;
		//min vaut 10, med vaut 20 et max vaut 25
	}

	public static void tp1_3() 
	{
		int min=20;
		int max=10;
		int med=25;
		int tmp=min;
		min=max;
		max=med;
		max=tmp;

		System.out.print("min vaut "+min+", med vaut "+med+" et max vaut "+max) ;
		//min vaut 10, med vaut 20 et max vaut 25
	}


	public static int carre(int nb)
	{
		return nb*nb;
	}

	public static void tp2_1() 
	{


		int nb = saisieInt("Saisir un nombre");
		//	int carre=nb*nb;
		System.out.println("Le carr� de "+nb+" est "+carre(nb));
	}

	public static void tp2_2() 
	{
		double HT=saisieDouble("Saisir prix HT");

		double TVA=saisieDouble("Saisir TVA (0.2 pour 20%)");

		int qte=saisieInt("Saisir qte");


		double TTC = qte * HT*(1+TVA);

		System.out.println("Montant TTC de votre commande : "+TTC+" �");
	}

	public static void tp4_1() 
	{
		int heure=saisieInt("Saisir heure");
		int min=saisieInt("Saisir min");
		String h="",m="";

		min++;

		if(min==60) 
		{
			heure++;
			min=0;
			if(heure==24) 
			{
				heure=0;
			}
		}
		if(heure<10) 
		{
			h="0"+heure;
		}
		else {h+=heure;}

		if(min<10) 
		{
			m="0"+min;
		}
		else {m+=min;}
		System.out.println("Dans une minute il sera "+h+":"+m);	
	}

	public static void tp4_3() 
	{
		int age=saisieInt("Saisir votre age");
		String civ=saisieString("Saisir civ (h/f)");


		if(
				(civ.equals("h") && age>=20) 
				|| 
				(civ.equals("f") && age>=18 && age<=35)

				) {System.out.println("Imposable");}

		else {System.out.println("Pas imposable");}
	}


	public static void tp4_4() {

		double score1=saisieDouble("Saisir score 1");
		double score2=saisieDouble("Saisir score 2");
		double score3=saisieDouble("Saisir score 3");
		double score4=saisieDouble("Saisir score 4");


		if( score1 >50 || score2>50 || score3>50 || score4>50) {
			if(score1>50) {System.out.println("Gagn� des le 1er tour");}
			else {System.out.println("Perdu des le 1er tour");}
		}
		else if (score1>12.5) 
		{
			if(score1>score2 && score1>score3 && score1>score4) 
			{
				System.out.println("Bal favorable");
			}
			else {
				System.out.println("Bal d�favorable");
			}
		}
		else {System.out.println("Perdu des le 1er tour (< � 12.5");}

	}


	public static void tp4_5() 
	{
		int age=saisieInt("Saisir votre age");
		int permis=saisieInt("Saisir permis");
		int accidents=saisieInt("Saisir nombre accidents");

		int score=1;

		if(age>=25) {score++;}
		if(permis>=2) {score++;}
		score-=accidents;

		if(score>0) 
		{
			int ancien = saisieInt("Saisir ancien");
			if (ancien>=5) {score++;}
		}

		/*if(score==1) {System.out.println("Tarif Rouge");}
		else if(score==2) {System.out.println("Tarif Orange");}
		else if(score==3) {System.out.println("Tarif Vert");}
		else if(score==4) {System.out.println("Tarif Bleu");}
		else {System.out.println("Refus�");}

		 */

		// Le switch fait la m�me chose que le bloc au dessus
		switch(score) 
		{
		case 1 : System.out.println("Tarif Rouge");break;
		case 2 : System.out.println("Tarif Orange");break;
		case 3 : System.out.println("Tarif Vert");break;
		case 4 : System.out.println("Tarif Bleu");break;
		default : System.out.println("Refus�");break;
		}



	}




	public static void tp4_6() 
	{

		int j=saisieInt("Jour ?");
		int m=saisieInt("Mois ?");
		int a=saisieInt("Ann�e ?");

		boolean dateValid=false;

		if(j>=1 && j<=31 && m>=1 && m<=12) 
		{

			if(m==2)
			{
				if((a%4==0 && a%100!=0) || a%400==0) {
					if(j<=29) {dateValid=true;}
				}
				else 
				{
					if(j<=28) {dateValid=true;}
				}
			}
			else if((m==4 || m==6 || m==9 || m==11) && j<=30) {dateValid=true;}
			else {dateValid=true;}


		}

		if(dateValid==true) {System.out.println("Date valide");}
		else {System.out.println("Date invalide");}


	}

	public static void exemple() 
	{
		//1 - Creation d'un Scanner 
		//		Scanner scInt = new Scanner(System.in);
		//		Scanner scString = new Scanner(System.in);
		//		
		//		//2-3 Declarer une variable de type int + utiliser un scanner Int
		//		System.out.println("Merci de saisir votre age");
		//		int age = scInt.nextInt();
		//		
		//		
		//		System.out.println("Merci de saisir votre prenom");
		//		String prenom=scString.nextLine();
		//		
		//		
		//		System.out.println("Hello world");
		//		
		//		System.out.println("Bonjour, je suis "+prenom+", j'ai "+age+"ans");
		//
		//	
	}




	public static void tp5_5() 
	{
		int nb;
		int max=0;
		for (int i=1;i<5;i++) 
		{
			nb=saisieInt("Saisir nombre");
			if(nb>max) 
			{
				max=nb;
			}
		}

		System.out.println("Les max est : "+max);
	}



	public static void main(String[] args) {
		
		
		
		int tableau[]= new int[3];
		
		int tableau2[]= {10,15,46};
		
		
		int sudoku[][]= new int[9][9];
		int sudoku2[][]= {
			{1,2,3,4,6,5,8,7,9},{8,7,6,0,0,4,2,1,3}
		};
		for(int ligne=0;ligne<9;ligne++) 
		{
			for(int col=0;col<9;col++) 
			{
				System.out.println(sudoku[ligne][col]);
			}
		}
		
		
		
		
		//Version 1 pour afficher un tableau
		for(int i=0;i<tableau2.length;i++)
		{
			int nb=tableau2[i];
			System.out.println(nb);
		}
		
		
		//Version 2 for each
		for(int nb : tableau2 ) 
		{
			System.out.println(nb);
		}
		
		//Version 3 
		
		System.out.println(Arrays.toString(tableau2));
		
		//tp5_5();
	}

}
