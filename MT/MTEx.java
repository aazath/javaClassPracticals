class Alpha extends Thread{
	public void run()
	{
		System.out.println("In the Alpha method");
	}
}

class Beta extends Thread
{
	public void run()
	{
		System.out.println("In the Beta mehtod");
	}
}

class Qama extends Thread
{
	public void run()
	{
		System.out.println("In the Qama method");
	}
}

public class MTEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alpha a = new Alpha();
		Beta b = new Beta();
		Qama q = new Qama();
		
		a.start();
		b.start();
		q.start();
	}

}
