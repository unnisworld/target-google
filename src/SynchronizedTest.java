import java.util.Collection;

public class SynchronizedTest {

	private static Collection<String> internalCollection;
	
	public synchronized void processCollection1(String foo) {
		if (internalCollection.contains(foo)) {
			// do something
		}
	}
	
	public static synchronized void processCollection2(String bar) {
		if (internalCollection.contains(bar)) {
			// do something
		}
	}
}
