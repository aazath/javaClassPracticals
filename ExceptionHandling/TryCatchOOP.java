import java.util.Scanner;

class Alpha{
	public void division()
	{
		try
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to our Application");
			System.out.println("==========================\n");
			System.out.println("Enter the first number to divide :");
			int first = scan.nextInt();
			System.out.println("Enter the second number to divide :");
			int second = scan.nextInt();
			
			int res = first/second;
			
			System.out.println("The result is "+res);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Enter non-zero second number");
		}
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


public class TryCatchOOP {

	public static void main(String[] args) {
		Beta b = new Beta();
		b.display();

	}

}
