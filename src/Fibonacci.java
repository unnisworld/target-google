
public class Fibonacci {
	
	public static void main(String args[]) {
		// System.out.println("fib(10) ="+ find_nth_fib(10));
		long[] mem = new long[101];
		System.out.println("fib(100) ="+ find_nth_fib_memoization(100, mem));
		System.out.println("fib(100) ="+ find_nth_fib_linear(100));
	}
	
	// O(2^n)
	private static long find_nth_fib(int n) {
		if (n <=1) {
			return n;
		}
		
		return find_nth_fib(n-1) + find_nth_fib(n-2);
	}
	
	private static long find_nth_fib_memoization(int n, long[] mem) {
		if(n <=1) {
			return n;
		}
		
		if (mem[n] != 0) {
			return mem[n];
		}
		
		long result = find_nth_fib_memoization(n-1, mem) + find_nth_fib_memoization(n-2, mem);
		mem[n] = result;
		return result;
	}
	
	//O(n)
	private static long find_nth_fib_linear(int n) {
		long previous = 0;
		long current  = 1;
		long next = 0;
		
		if(n <= 1) return n;
		
		for(int i=1;i<n;i++) {
			next = current + previous;
			previous = current;
			current = next;
		}
		
		return next;
	}
}
