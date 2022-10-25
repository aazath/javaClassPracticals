import java.util.Scanner;

class Alpha{
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

class Beta{
	public void display()
	{
		Alpha a = new Alpha();
		a.division();
		
	}
}


public class DuckingEx {

	public static void main(String[] args) {
		try
		{
			Beta b = new Beta();
			b.display();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Your input is wrong. Enter a non-zero second number.");
			e.printStackTrace();
		}
	}

}
