class chainThreading extends Thread
{
	public void run()
	{
		String t =Thread.currentThread().getName();
		if (t.equals("Bank")) {
			Banking();
		}
		else if(t.equals("Print"))
		{
			Printing();
		}
		else
		{
			Calc();
		}
	}
	
	public void Banking() {
		System.out.println("Banking Task Started...");
		
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Banking...");
			
		}
		System.out.println("Banking completed....");
	}
	
	public void Printing() {
		System.out.println("Printing Task Started...");
		
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Printing...");
			
		}
		System.out.println("Printing completed....");
	}
	
	public void Calc() {
		System.out.println("Calc Task Started...");
		
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Calc...");
			
		}
		System.out.println("Calc completed....");
		
	}
}
public class ChainingMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chainThreading ct1 = new chainThreading();
		chainThreading ct2 = new chainThreading();
		chainThreading ct3 = new chainThreading();
		
		ct1.setName("Bank");
		ct2.setName("Print");
		ct3.setName("Calc");
		
		ct1.start();
		ct2.start();
		ct3.start();
	}

}
