
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(binarySearch(arr, 0, arr.length-1, 7));
	}

	static int binarySearch(int[] a, int l, int r, int e) 
	{
		if (r >= l) {
			int m = l + (r - l)/2;
			
			if (a[m] == e)
				return m;
			
			if (a[m] > e) {
				return binarySearch(a, l, m-1, e);
			} 
			
			return binarySearch(a, m+1, r, e); 
		}
		
		return -1;
	}
}
