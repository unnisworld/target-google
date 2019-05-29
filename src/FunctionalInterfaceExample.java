
public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc = (n1, n2) -> n1 + n2;
		
		System.out.println(calc.calculate(1, 2));
		
		System.out.println(calculate( (n1, n2) -> n1 * n2 ));
		
		Calculator calc2 = MyUtil::calc;
		
		System.out.println(calc2.calculate(1, 5));
		
		TaskHander t = Utility::new;
		t.get("Hello");
	}
	
	private static long calculate(Calculator c) {
		return c.calculate(3, 4);
	}
	
	// How to define a functional interface.
	@FunctionalInterface
	interface Calculator {
		long calculate(long num1, long num2);
	}
	
	static class MyUtil 
	{
		public static int calc(long num1, long num2) {
			return (int)(num1 + num2);
		}
	}
	
	@FunctionalInterface
	interface TaskHander {
		void get(String tname);
	}
	
	static class Utility {
		Utility(String name) {
			System.out.println(name);
		}
	}

}


