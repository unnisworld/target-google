package corejava;

public class OddEvenPrint {

	public static void main(String[] args) {
		OddEvenLock lock = new OddEvenLock();
		lock.printEven = true;
		Thread t1 = new Thread(new EvenPrinter(lock));
		Thread t2 = new Thread(new OddPrinter(lock));
		t1.start();
		t2.start();
	}

}

class EvenPrinter implements Runnable {
	OddEvenLock lock;
	EvenPrinter (OddEvenLock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		synchronized(lock) { 
			for (int i=0; i < 101; i+=2) {
				while (lock.printEven == false) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + i);
				lock.printEven = false;
				lock.notifyAll();
			}
		}
	}	
	
}

class OddPrinter implements Runnable {
	OddEvenLock lock;
	OddPrinter (OddEvenLock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		synchronized(lock) {
			for (int i=1; i < 100; i+=2) {
				while (lock.printEven == true) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(i);
				lock.printEven = true;
				lock.notifyAll();
			}
		}
		
	}	
	
}

class OddEvenLock {
	public boolean printEven;

}
