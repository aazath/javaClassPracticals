import java.util.Scanner;

//This application will create a custom exception for the specific scenario
//Wrong Pin input for ATM card

class InvalidUserException extends Exception
{
	InvalidUserException(String message)
	{
		super(message);
	}
}

class ATM{
	private int accountNum = 1111;
	private int password = 2222;
	private int acNo;
	private int pw;
	
	Scanner scan = new Scanner(System.in);
	
	public void input()
	{
		System.out.println("Enter your Account No : ");
		acNo = scan.nextInt();
		System.out.println("Enter your Pin Code : ");
		pw = scan.nextInt();
	}
	
	public void verify()throws InvalidUserException
	{
		if(accountNum ==  acNo &&  pw == password) {
			System.out.println("You can widthraw money.");
		}
		else
		{
			//System.out.println("Wrong credentials");
			throw new InvalidUserException("Wrong credentials !");
		}
	}
}

class Bank
{
	public void initiate()
	{
		ATM atm = new ATM();
		try {
			atm.input();
			atm.verify();
			
		}catch(InvalidUserException iue)
		{
			try {
				System.out.println(iue.getMessage());
				atm.input();
				atm.verify();
			}
			catch(InvalidUserException e) {
				try {
					System.out.println(e.getMessage());
					atm.input();
					atm.verify();
				}
				catch(InvalidUserException ue)
				{
					System.out.println("Your card is blocked! Contact the Bank");
					System.exit(0);
				}
			}
		}
	}
	
	
}


public class OwnException {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.initiate();

	}

}
