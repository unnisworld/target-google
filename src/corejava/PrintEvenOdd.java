package corejava;

public class PrintEvenOdd {

	public static void main(String[] args) {
		EvenOddLock lock = new EvenOddLock();
		Thread printEven = new Thread(new PrintEven(lock));
		Thread printOdd = new Thread(new PrintOdd(lock));
		
		lock.printEvent = true;
		
		printEven.start();
		printOdd.start();
	}

}

class EvenOddLock {
	public boolean printEvent;
}

class PrintEven implements Runnable {
	private EvenOddLock lock;
	PrintEven(EvenOddLock lock) {
		this.lock = lock;
	}
	
	public void run() {
		synchronized(lock) {
			for (int i=0;i<100;i = i+2)
			{
				while(lock.printEvent == false) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(i);
				lock.printEvent = false;
				lock.notifyAll();
			}
		}
	}
}

class PrintOdd implements Runnable {
	
	private EvenOddLock lock;
	PrintOdd(EvenOddLock lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized(lock) {
			for (int i=1;i<100;i=i+2)
			{
				while (lock.printEvent == true) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(i);
				lock.printEvent = true;
				lock.notifyAll();
			}
		}
	}
}
