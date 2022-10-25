import java.util.Scanner;

class PClass{
	public void division()throws ArithmeticException
	{
	
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to our Application");
			System.out.println("==========================\n");
			System.out.println("Ducking the Exception with throws keyword");
			System.out.println("Enter the first number to divide :");
			int first = scan.nextInt();
			System.out.println("Enter the second number to divide :");
			int second = scan.nextInt();
			
			int res = first/second;
			
			System.out.println("The result is "+res);
			
		System.out.println("Thank you for using our application");
	}
}

class CClass{
	public void display()
	{
		PClass a = new PClass();
		a.division();
		
	}
}


public class DuckingEx {

	public static void main(String[] args) {
		try
		{
			CClass b = new CClass();
			b.display();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Your input is wrong. Enter a non-zero second number.");
			e.printStackTrace();
		}
	}

}
