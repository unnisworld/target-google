import java.util.Arrays;

class Solution {
//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        
//    	while( m > 0 || n > 0 ){
//            if(n==0) break;
//            if(m==0){
//                nums1[n-1] = nums2[n-1];
//                n--;
//                continue;
//            }
//            if(nums1[m-1]>nums2[n-1]){
//                nums1[m+n-1] = nums1[m-1];
//                m--;
//            }else{
//                nums1[m+n-1] = nums2[n-1];
//                n--;
//            }
//        }
//        
//    }
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n != 0) {
            
            if (m==0) {
                nums1[n-1] = nums2[n-1];
                n--;
                continue;
            }
            
            if (nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] arr1 = {4,0,0,0,0,0};
    	int[] arr2 = {1,2,3,5,6};
    	
    	merge(arr1, 1, arr2, 5);
    	
    	System.out.println(Arrays.toString(arr1));
    }
}