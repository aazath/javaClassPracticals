//This java application will use the concept of dead lock 
//in multi threading
//synchronized - used to lock the resource only for one thread

class Warrior implements Runnable
{
	//declare the types of weapon warrior need
	String res1 = new String("Sword");
	String res2 = new String("Axe");
	String res3 = new String("Hoe");
	
	
	
	public void run()
	{
		String curThread = Thread.currentThread().getName();
		
		try {
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


	//warrior 1 gets the weapon
	public void tomAcq()
	{
		try {
			Thread.sleep(4000);
			
			//gets the resource
			synchronized(res1)
			{
				System.out.println("Tom acquired "+res1);
				System.out.println("Tom using "+res1);
				
				//wait for some more time to get more weapon
				Thread.sleep(4000);
				
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


	//warrior 2 gets the weapon
	public void jerryAcq()
	{
		try {
			Thread.sleep(4000);
			
			//gets the resource
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
		Warrior wr = new Warrior();
		
		Thread tom = new Thread(wr);
		Thread jerry = new Thread(wr);
		
		tom.setName("Tom");
		jerry.setName("Jerry");
		
		tom.start();
		jerry.start();

	}

}

