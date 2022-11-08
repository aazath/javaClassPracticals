class Task extends Thread {
    public Task(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }
 
    public void run() {
        boolean running = true;
 
        while (running) {
            try {
                System.out.println(getName() + " is running");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                running = false;
                System.out.println(getName() + " is interrupted and then terminates");
            }
        }
    }
}

public class ThreadGroupEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ThreadGroup group = new ThreadGroup("GroupA");
		 
	        new Task(group, "A").start();
	        new Task(group, "B").start();
	        new Task(group, "C").start();
	        new Task(group, "D").start();
	 
	        try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        group.interrupt();

	}

}
