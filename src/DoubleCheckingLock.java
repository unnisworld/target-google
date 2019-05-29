
public class DoubleCheckingLock {

	public static void main(String[] args) {
		
	}
}

class Configurator {
	private Configurator() {
		
	}
	
	public static Configurator getInstance() {
		return INSTANCE;
	}
	
	private static Configurator INSTANCE = new Configurator();
}
