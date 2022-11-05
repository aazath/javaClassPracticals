class Banking implements Runnable
{
	public void run()
	{
		System.out.println("banking task started ");
		
		for(int i=0;i<3;i++)
		{
			try {
				Thread.sleep(2000);
				
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Banking........");
		}
		System.out.println("Banking completed....");
	}
}
class Printing implements Runnable
{
	
	public void run()
	{
		System.out.println("printing activity ");
		
		for(int i=0;i<3;i++)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("printing........");
		}
		System.out.println("printing completed....");
	}
	
}
class Calc implements Runnable
{
   public void run()
   {

		System.out.println("calculation task started ");
		
		for(int i=0;i<3;i++)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("some calculation........");
		}
		System.out.println("calculation completed completed....");
   }
}
public class LaunchRun {

	public static void main(String[] args) throws Exception
	{
		
		System.out.println("Main thread got the chance first");
		Thread t=Thread.currentThread();
		
		System.out.println(t.isAlive());
		Banking d1=new Banking();
		Printing d2=new Printing();
		Calc d3=new Calc();
		
		
		
		Thread t1=new Thread(d1);
		Thread t2=new Thread(d2);
		Thread t3=new Thread(d3);
		
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println(t3.isAlive());
		
		t1.start();
		System.out.println(t1.isAlive());
		t2.start();
		t3.start();
		
		
		//join method will put the main thread wait until 
		//the other threads complete running
		//without join method main thread will complete first
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Main thread is completing first also");

	}
}