package corejava;

public class PrintEvenOddApproachOne {

	private static volatile int count = 1;
	private static final int max = 100;
	private static volatile boolean odd = true;
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
			while (count < max) {
				
				// wait till notified or "odd" flag's value is flipped.
				while(odd) {
					try {
						synchronized(lock) {
							// wait with a timeout to avoid indefinite wait scenario 
							lock.wait(5);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // end of wait 
				
				// Print next even value
				System.out.println(count);
				count++;
				
				// flip flag value
				odd = true;
				
				// Notify other thread
				synchronized(lock) {
					lock.notifyAll();
				}
			}	
		}
		
	}
	
	static class OddPrinter implements Runnable {

		@Override
		public void run() {
			while(count < max) {
				
				// wait till notified or "odd" flag's value is flipped.
				while(!odd) {
					try {
						synchronized(lock) {
							// wait with a timeout to avoid indefinite wait scenario 
							lock.wait(5);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // end of wait 
				
				// Print next odd value
				System.out.println(count);
				count++;
				
				// flip flag value
				odd = false;
				
				// Notify other thread
				synchronized(lock) {
					lock.notifyAll();
				}
			}
		}
		
	}


}
