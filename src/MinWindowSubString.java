
// https://leetcode.com/problems/minimum-window-substring/solution/
public class MinWindowSubString {

	public static void main(String[] args) {
		
		// String str = "ABAACBAB";
		// String str = "ADOBECODEBANC";
		// String ptn = "ABC";
		
		String str = "this is a test string";
		String ptn = "tist";

		
		System.out.println(findMinWindow(str, ptn));

	}
	
	private static String findMinWindow(String str, String patn) {
		
		String solution = "";
		int plen = patn.length();
		int slen = str.length();
		
		if (slen < plen) {
			return "";
		}
		
		int[] hashPtn = new int[256];
		int[] hashStr = new int[256];
		
		// find count of each char in pattern.
		for (int i=0;i<plen;i++) {
			hashPtn[patn.charAt(i)]++;
		}
		
		int minWindowStartNdx = 0;
		int minWindowLen = Integer.MAX_VALUE;
		int curWindowStartNdx = 0;
		int windowEndNdx = Integer.MAX_VALUE;
		int usefulCharCount = 0;

		for(int ndx = 0; ndx < slen; ndx++) {
			
			// if it's a char present in pattern - it's a useful char
			if ( hashPtn[str.charAt(ndx)] > 0 ) {								
				hashStr[str.charAt(ndx)]++;
				
				if (hashStr[str.charAt(ndx)] <= hashPtn[str.charAt(ndx)]) {
					usefulCharCount++;
				}
			}
			
			// if all useful chars are found, we have found a possible solution.
			if (usefulCharCount == plen) 
			{
				windowEndNdx = ndx;				
			
				// Now try to optimize it by removing extra useful chars and useless chars		
				while ( hashStr[str.charAt(curWindowStartNdx)] > hashPtn[str.charAt(curWindowStartNdx)] ||
						hashPtn[str.charAt(curWindowStartNdx)] == 0 ) 
				{				
					if (hashStr[str.charAt(curWindowStartNdx)] > hashPtn[str.charAt(curWindowStartNdx)]) {
						hashStr[str.charAt(curWindowStartNdx)]--;
					}
					curWindowStartNdx++;				
				} // end of optimization loop.
				
				// if current solution's window len is less that what we already have, replace it.
				if ( (windowEndNdx - curWindowStartNdx) < minWindowLen ) {
					minWindowLen = windowEndNdx - curWindowStartNdx;
					minWindowStartNdx = curWindowStartNdx;
					
					solution = str.substring(minWindowStartNdx, windowEndNdx + 1);
				}
				
				// continue search for smaller substrings
				hashStr[str.charAt(curWindowStartNdx)]--;
				curWindowStartNdx++;
				usefulCharCount = usefulCharCount - 1;
				
			}
			
		} // outer for loop
		
		return solution;
	}

}
