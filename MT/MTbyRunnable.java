class A implements Runnable
{
	public void run()
	{
		System.out.println("In the A method");
	}
}

class B implements Runnable
{
	public void run()
	{
		System.out.println("In the B method");
	}
}

class C implements Runnable
{
	public void run()
	{
		System.out.println("In the C method");
	}
}
public class MTbyRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		C c = new C();
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		Thread t3 = new Thread(c);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
