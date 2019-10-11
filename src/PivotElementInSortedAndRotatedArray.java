
public class PivotElementInSortedAndRotatedArray {

	public static void main(String[] args) {
		
		// TODO : Fix it.
		int[] arr = {3, 4, 5, 6, 7, 8, 9, 1, 2};
		
		System.out.println(pivotIndex(arr, 0, arr.length));
	}

	static int pivotIndex(int[] a, int l, int r) 
	{
		if (r >=l) {
			int m = l + (r-l)/2;
			
			if (a[m] > a[m-1] && a[m] > a[m+1])
				return m;
			
			if (a[m] > a[r-1])
				return pivotIndex(a, m+1, r);
			
			return pivotIndex(a, l, m-1);
		}
		
		return -1;
	}
}
