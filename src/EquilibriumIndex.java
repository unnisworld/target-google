
public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		
		int total = 0;
		for (int i = 0;i<arr.length; i++) {
			total = total + arr[i];
		}
		
		int leftSum = 0;
		int rightSum = total;
		boolean found = false;
		for(int i=0;i<arr.length;i++) {
			rightSum = rightSum - arr[i];
			if (rightSum == leftSum) {
				System.out.println(i);
				found = true;
				break;
			}
			leftSum = leftSum + arr[i];
		}
		
		if (!found)
			System.out.println(-1);
	}

}
