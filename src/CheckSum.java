import java.util.HashMap;
import java.util.Map;

class CheckSum
{   
  public static int[] findSum(int[] arr, int value) 
  {
    int[] result = new int[2];
    // write your code here
    Map<Integer, Integer> map = new HashMap<>();
    for (int i=0;i<arr.length;i++) {
      map.put((value-arr[i]), i);
    }  
    
    for (int i=0;i<arr.length;i++) {
      if (map.get(arr[i]) != null ) {
        
      }  
    }
   
    return result;   // return the elements in the array whose sum is equal to the value passed as parameter 
  }
}