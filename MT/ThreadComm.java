//This java application demonstrates the communication b/w the threads

//producer thread operation
class Producer extends Thread
{
		// Producer producing the data in StringBuffer
		StringBuffer sb;

		// variable used by thread for Communication
		boolean dataProvider = false;

		public Producer() {
			// StringBuffer object is created with a default capacity 16
			sb = new StringBuffer();
		}

		@Override
		public void run() {
			//apply lock
			synchronized(sb) {

			for (int i = 1; i <= 10; i++) {
				try {
					sb.append(i + ": ");
					Thread.sleep(100);
					System.out.println("appending");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			//send the notification to the waiting thread
			sb.notify();
			}

			// update the consumer once data produced
//			dataProvider = true;

		}
	
}


//consumer thread operations
class Consumer extends Thread
{
		// Creating producer object to get the produced data from StringBuffer
		Producer producer;
		
		
		//injecting the Producer Object into Consumer - DI
		public Consumer(Producer producer) {
			this.producer = producer;
		}


		@Override
		public void run() {
			
//			//check for the producer dataProvider for the dataProvider variable
//			//if true only consume the data otherwise enter into sleeping state
//			while(producer.dataProvider == false) {
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			//consume the data produced by the producer
//			System.out.println(producer.sb);
			
			synchronized(producer.sb) {
				try {
					//wait till the notification is sent by producer
					producer.sb.wait();
					
					//consume the data produced by the producer
					System.out.println(producer.sb);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
}

//Efficient way of inter-thread communication using wait() and notify()
public class ThreadComm {

	//Driving code where he starts the other thread
	public static void main(String[] args) {

			Producer obj1 = new Producer();
			Consumer obj2 = new Consumer(obj1);
			
			
			Thread t1 = new Thread(obj1);//producer thread
			Thread t2 = new Thread(obj2);//consumer thread
			
			t2.start();//consumer should wait
			t1.start();//producer should start
				
		}

}


