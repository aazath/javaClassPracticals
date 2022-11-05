//This application will demonstrate the usage of sync block
//only a single block of code can be sync
class AMC implements Runnable{
	public void run() 
	{
		try {
		//numbers will be printed in random order
		//bcs, this block will be executed by multiple threads simultaneously
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		Thread.sleep(2000);
		
		//synchronized block to prevent the multi thread running
		//alpabhets everytime will be printed in the order
		synchronized(this)
		{
		for (int i = 0; i < 5; i++) {
			System.out.println((char)(i + 65));
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}



//Driver code

public class SyncBlock {

	public static void main(String[] args) {
		// create only one object (resource)
		AMC a1 = new AMC();
		
		//create multiple threads
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		Thread t3 = new Thread(a1);
		
		//these threads will cause the race condition problem
		t1.start();
		t2.start();
		t3.start();

	}

}
