package corejava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable r = () -> System.out.println("Hello World");
		
		Thread t = new Thread(r);
		t.start();
		
		Callable<String> c = () -> { return "foo";};
		
		ExecutorService service =  Executors.newSingleThreadExecutor();
		Future<String> result = service.submit(c);
	
		System.out.println(result.get());	
		
		service.shutdownNow();
	}
	

}
