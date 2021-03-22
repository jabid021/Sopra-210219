import java.util.Scanner;

public class Number
{
	public static void main (String [] args){
		int lastDigit = 0;
		int Addition = 0;
		int reversed = 0;
		int num2 = 0;
		System.out.println("Enter a 4 digits number");
		Scanner scan = new Scanner (System.in);
		int num = scan.nextInt();

		if ((num > -10000 && num < -999) || (num > 999 && num < 10000))
		{
			System.out.println("1. Reverse sign.");
			System.out.println("2. Reverse number.");
			System.out.println("3. Reverse sign and number");
			System.out.println("Please choose an option: ");
			num2 = scan.nextInt();


			switch(num2) {
			case 1: System.out.println("The result is: " + num/-1);
			break;
			case 2: 
				lastDigit = num % 10; 
				Addition = (Addition + lastDigit) * 10; 
				num /= 10; 

				lastDigit = num % 10; 
				Addition = (Addition + lastDigit) * 10; 
				num /= 10; 

				lastDigit = num % 10; 
				Addition = (Addition + lastDigit) * 10; 
				num /= 10; 

				reversed = num + Addition;
				System.out.println("The result is: " + reversed);
				break;

			case 3: 
				lastDigit = num % 10; 
				Addition = (Addition + lastDigit) * 10; 
				num /= 10; 

				lastDigit = num % 10; 
				Addition = (Addition + lastDigit) * 10; 
				num /= 10; 

				lastDigit = num % 10; 
				Addition = (Addition + lastDigit) * 10; 
				num /= 10; 

				reversed = num + Addition;

				System.out.println("The result is " + reversed/-1);
				break;

			default : System.out.println("Illegal option " + "–" + " you must choose 1, 2 or 3");
			}
		}
		else {
			System.out.println("Illegal number " + "–" + " you must enter a 4 digit number");
		}












	}
}