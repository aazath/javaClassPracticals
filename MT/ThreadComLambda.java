//This java application will use lambda expression to communicate with other threads
//minimum class files need minimum resources to run the application
public class ThreadComLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//Anonymous inner class
//		new Thread(new Runnable() {
//			public void run()
//			{
//				for (int i = 1; i <= 5; i++) {
//					try {
//						System.out.println("Child thread");
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
		
		//Lambda expression
		//new Thread(()->{//program logic}).start();
		new Thread(() -> {
			//body of the method
			for (int i = 1; i <= 5; i++) {
				try {
					System.out.println("Child thread");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		for (int i = 1; i <= 5; i++) {
			try {
				System.out.println("Main thread");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
