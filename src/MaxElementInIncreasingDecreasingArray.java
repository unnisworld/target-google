
public class MaxElementInIncreasingDecreasingArray {

	public static void main(String[] args) {
        //int arr[] = {1, 3, 50, 10, 9, 7, 6}; 
		// int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        // int arr[] = {10, 20, 30, 40, 50};
        int arr[] = {120, 100, 80, 20, 0};
        
		int n = arr.length; 
        System.out.println("The maximum element is "+  
        						findMax(arr, 0, n-1));
	}
	
	private static int findMax(int[] a, int l, int r) 
	{
		if (l == r) 
			return a[r];
		
		if ( (r == (l+1)) && (a[l] >= a[r]) )
			return a[l];

		if ( (r == (l+1)) && (a[l] < a[r]) )
			return a[r];
		
		int m = l + (r-l)/2;
		
		if (a[m] > a[m-1] && a[m] > a[m+1])
			return a[m];
		
		if (a[m] > a[m+1] && a[m] < a[m-1]) 
			return findMax(a, l, m-1);
		else
			return findMax(a, m+1, r);
	}

}
