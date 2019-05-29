import java.util.HashMap;
import java.util.Map;

public class CheckIfSubArrayZeroSumExists {

	public static void main(String[] args) {
		// int[] arr = {4, 2, -3, 1, 6};
		int[] arr = {-3, 2, 3, 1, 6};
		System.out.println(checkSubArrayZeroSumExists(arr));
	}
	
	private static boolean checkSubArrayZeroSumExists(int[] arr) {
		Map<Integer, Boolean> previousSums = new HashMap<>();
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			
			if (arr[i] == 0 || sum == 0 || previousSums.get(sum) == Boolean.TRUE) {
				return true;
			}
			
			previousSums.put(sum, Boolean.TRUE);
		}
		
		return false;
	}

}
