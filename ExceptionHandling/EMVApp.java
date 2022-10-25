import java.util.Scanner;

class UnderAgeException extends Exception
{
	UnderAgeException(String msg)
	{
		super(msg);
	}
}

class OverAgeException extends Exception
{
	OverAgeException(String msg)
	{
		super(msg);
	}
}

class Applicant{
	private int age;
	Scanner scan = new Scanner(System.in);
	
	public void input()
	{
		System.out.println("Enter your age for eligibility check :");
		age = scan.nextInt();
	}
	
	public void verify()throws OverAgeException, UnderAgeException
	{
		if(age>=18 && age <=60)
		{
			System.out.println("You are eligible for Driving");
		}
		else if(age>60)
		{
			throw new OverAgeException("You are too old to drive");
		}
		else
		{
			throw new UnderAgeException("You are too young to drive, So wait until 18th Birthday");
		}
	}
}

class EMV{
	public void initiate()
	{
		Applicant app = new Applicant();
		try
		{
			app.input();
			app.verify();
		}
		catch(UnderAgeException uae)
		{
			System.out.println(uae.getMessage());
			try
			{
				app.input();
				app.verify();
			}
			catch(OverAgeException oae)
			{
				System.out.println(oae.getMessage());
				System.out.println("Seems suspicious");
				System.exit(0);
			}
			catch(UnderAgeException a)
			{
				System.out.println(a.getMessage());
				System.out.println("Seems suspicious");
				System.exit(0);
			}
		}
		catch(OverAgeException o)
		{
			System.out.println(o.getMessage());
			try
			{
				app.input();
				app.verify();
			}
			catch(OverAgeException oae)
			{
				System.out.println(oae.getMessage());
				System.out.println("Seems suspicious");
				System.exit(0);
			}
			catch(UnderAgeException a)
			{
				System.out.println(a.getMessage());
				System.out.println("Seems suspicious");
				System.exit(0);
			}
		}
	}
	
}
public class EMVApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EMV emv = new EMV();
		emv.initiate();

	}

}
