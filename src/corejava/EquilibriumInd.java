package corejava;

//Input : A[] = {-7, 1, 5, 2, -4, 3, 0} Output : 3
//                0  1  2  3   4  5  6
//3 is an equilibrium index, because: A[0]+A[1]+A[2] = A[4]+A[5]+A[6]

public class EquilibriumInd {
	
	public static void main(String[] args) {
		int arr[]={-7, 1, 5, 2, -4, 3, 0};
		int arrTotal = 0;
		for (int i=0;i<arr.length;i++) {
			arrTotal = arrTotal + arr[i];
		}
		int leftSum = 0;
		int rightSum = 0;
		
		for (int i=0;i<arr.length;i++) {
			if (i==0) {
				leftSum = 0;
				rightSum = arrTotal - arr[i];
			}
			else if (i== arr.length - 1) {
				leftSum = arrTotal - arr[i];
				rightSum = 0;
			}
			//Input : A[] = {-7, 1, 5, 2, -4, 3, 0} Output : 3
			//                0  1  2  3   4  5  6
			
			else {
				leftSum = leftSum + arr[i-1];
				rightSum = arrTotal - leftSum - arr[i];
			}
			
			
			System.out.println("i = " + i + " Left sum = " + leftSum + " Right sum = " + rightSum);
			
			if (leftSum == rightSum) {
				System.out.println("Equilibrium Index = " + i);
				return;
			}
		}
		
		
	}
	
	

}
