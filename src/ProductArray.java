import java.util.Arrays;

class ProductArray  
{  /* Function to print product array for a given array  arr[] */
  public static int[] findProduct(int arr[])  
  {    
    int n = arr.length;
    int [] product = new int[n];
    
    for (int i=0;i<n;i++) {
      product[i] = 1;
    }
    
    int temp = 1;
    for(int i=0;i<n;i++) {
      product[i] = temp;
      temp = temp * arr[i];
    }  
    
    temp = 1;
    for(int i=n-1;i>=0;i--) {
      product[i] = product[i]  * temp;
      temp = temp * arr[i];
    }  

    return product; 
   } 
  
  public static void main(String[] args) {
	  int arr[] = {1,2,3,4};
	  int[] prod = findProduct(arr);
	  System.out.println(Arrays.toString(prod));
  }
} 