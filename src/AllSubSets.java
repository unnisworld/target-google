
/**
 * https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 * 
 * Print all subsets of a set.
 * Runs in O(2^n)
 * @author uvalsala
 *
 */
public class AllSubSets {

	public static void main(String[] args) 
	{
		char[] arr = {'a', 'b', 'c'}; 
		printAllSubSets(arr);
	}
	
	private static void printAllSubSets(char[] arr) {
		int n = arr.length;
		
		// 1 << n is short way to calculate 2^n.
		for (int i=0; i<(1<<n); i++) 
		{
			System.out.print("{");
			for(int j=0;j<n;j++) {
				if ( (i & (1<<j)) > 0 ) {
					System.out.print(arr[j]);
				}
			}
			System.out.println("}");
		}
	}

}
