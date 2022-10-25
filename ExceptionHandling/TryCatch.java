

import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Welcome to AyaINN Application");
		System.out.println("=============================");
		System.out.println("Enter the first number to devide: ");
		int first = scan.nextInt();
		System.out.println("Enter the second number to devide: ");
		int second = scan.nextInt();
		
		try
		{
			System.out.println("The Result of the Division "+(first/second));
		}
		catch(ArithmeticException e)
		{
			System.out.println("Unable to Devide, Enter a non-zero second number.");
		}
		

	}

}
