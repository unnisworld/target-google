package corejava;

public class PrintEvenOddBuggy {

	private static Object lock = new Object();
	
	public static void main(String[] args) throws Exception {
		Thread evenThread = new Thread(new EvenPrinter()); 
		
		Thread oddThread = new Thread(new OddPrinter());
		
		
		evenThread.start();
		oddThread.start();
		
		evenThread.join();
		oddThread.join();
	}

	static class EvenPrinter implements Runnable {

		@Override
		public void run() {
			for (int i=1;i<=100;i++) {
				if (i % 2 == 0) 
				{
					System.out.println(i);
					synchronized(lock) {
						lock.notifyAll();
					}
				}	else {
					try {
						synchronized(lock) {
							lock.wait();
						}	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	static class OddPrinter implements Runnable {

		@Override
		public void run() {
			for (int i=1;i<=100;i++) {
				if (i % 2 == 1) 
				{
					System.out.println(i);
					synchronized(lock) {
						lock.notifyAll();
					}
				}	else {
					try {
						synchronized(lock) {
							lock.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
