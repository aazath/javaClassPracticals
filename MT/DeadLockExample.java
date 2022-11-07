//This java application will use the concept of dead lock 
//in multi-threading
//synchronized - used to lock the resource only for one thread

class Warrior implements Runnable
{
	//declare the types of weapon warrior need
	String res1 = new String("Sword");
	String res2 = new String("Axe");
	String res3 = new String("Hoe");
	
	//thread scheduler will select a thread to run, that thread will 
	//get the chance to execute the run()
	//other thread will be moved to blocked state
	public void run()
	{
		//get the name of the current thread
		String curThread = Thread.currentThread().getName();
		
		try {
			//if Tom thread get chance then run tomAcq()
			//else run the jerryAcq()
			if (curThread.equals("Tom")) {
				tomAcq();
			}
			else
			{
				jerryAcq();
			}
		} catch (Exception e) {
			System.out.println("Some interruption");
		}
	}


	//Tom gets the weapon
	public void tomAcq()
	{
		try {
			//once the thread encounter the sleep state
			//it will moved to sleep state from running state
			//TS will give chance to the other thread
			//in other thread the first line also sleep method
			//so, the other thread also will be moved to the sleep state
			//in mean time, this thread's sleep time will get over
			//and let's assume this thread execute the synchronized(res1)
			//on the other hand, the next thread's sleep time over
			//and try to execute the synchronized(res1)
			//this already locked by the first thread
			//so, the second thread will move to the blocked state due to resource unavailability
			//and will come out of of the blocked state after the resources are released by the first thread
			Thread.sleep(4000);
			
			//gets the resource
			synchronized(res1)
			{
				System.out.println("Tom acquired "+res1);
				System.out.println("Tom using "+res1);
				
				//wait for some more time to get more weapon
				Thread.sleep(4000);
				//this thread will moved to the sleep state
				//and moved to the runnable state after the sleep time is over
				synchronized(res2)
				{
					System.out.println("Tom acquired "+res2);
					System.out.println("Tom using "+res2);
					
					//wait for some more time to get more weapon
					Thread.sleep(4000);
					
					synchronized(res3)
					{
						System.out.println("Tom acquired "+res3);
						System.out.println("Tom using "+res3);
					}
				}
				
			}
			System.out.println("Tom releasing his all weapons");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//Jerry gets the weapon
	public void jerryAcq()
	{
		try {
			Thread.sleep(4000);
			//gets the resource
			//in case, the res1 is already acquired by the other thread
			//this thread will moved to the blocked state
			//if res1 is available state
			synchronized(res1)
			{
				System.out.println("Jerry acquired "+res1);
				System.out.println("Jerry using "+res1);
				
				
				//wait for some more time to get more weapon
				Thread.sleep(4000);
				
				synchronized(res2)
				{
					System.out.println("Jerry acquired "+res2);
					System.out.println("Jerry using "+res2);
					
					//wait for some more time to get more weapon
					Thread.sleep(4000);
					
					synchronized(res3)
					{
						System.out.println("Jerry acquired "+res3);
						System.out.println("Jerry using "+res3);
					}
				}
				
			}
			System.out.println("Jerry releasing all his weapons");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class DeadLockExample {

	public static void main(String[] args) {
		//create the warrior object
		Warrior wr = new Warrior();
		
		//create 2 separate threads by passing the object
		Thread tom = new Thread(wr);
		Thread jerry = new Thread(wr);
		
		//set names to the threads
		tom.setName("Tom");
		jerry.setName("Jerry");
		
		//run the threads
		tom.start();
		jerry.start();

	}

}

