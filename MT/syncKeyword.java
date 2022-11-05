//This java application demonstrates the usage of the synchronised keyword

class BathRoom implements Runnable
{
	//make the run() as sync
	//so, only one thread will execute the method at a time
	synchronized public void run()
	{
	
		try 
		{
			System.out.println(Thread.currentThread().getName() + " has enterted the bathroom");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " is using bathroom");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " exited the bathroom");
			
		} 
		
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
	}
}

public class syncKeyword {

	public static void main(String[] args) 
	{
		System.out.println("Main thread started");		
		BathRoom b=new BathRoom();
		
		Thread t1=new Thread(b);
		Thread t2=new Thread(b);
		Thread t3=new Thread(b);
		
		t1.setName("BOY");
		t2.setName("GIRL");
		t3.setName("TIKTOKER");
		
		t1.start();
		
		//main thread will wait until t1 & t2 finish 
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		
		System.out.println("Main thread finished");

		
	}

}