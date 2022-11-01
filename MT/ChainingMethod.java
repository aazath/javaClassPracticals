class chainThreading extends Thread
{
	public void run()
	{
		try {
			A();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			B();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			C();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void A() throws Exception
	{
		System.out.println("In the A method");
		Thread.sleep(5000);
	}
	
	public void B() throws Exception
	{
		System.out.println("In the B method");
		Thread.sleep(5000);
	}
	public void C()throws Exception
	{
		System.out.println("In the C method");
		Thread.sleep(5000);
	}
}
public class ChainingMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chainThreading ct = new chainThreading();
		ct.start();

	}

}
