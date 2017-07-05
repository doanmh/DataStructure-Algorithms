package ctci.chapter01.question02_CheckPermutation;

/**
 * 
 * @author Minh Doan
 * Implementation using frequency array
 * 
 * Time Complexity: O(n) - Space Complexity: O(n)
 * 
 * Assumption: The characters are ASCII characters and the input is valid
 *
 */

public class Question02Answer {
	public static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;	
		}
		int[] freq = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			int index = str1.charAt(i);
			freq[index]++;	
		}
		for (int i = 0; i < str2.length(); i++) {
			int index = str2.charAt(i);
			if (freq[index] == 0) {
				return false;			
			} else {
				freq[index]--;	
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		System.out.println(checkPermutation("abcdef", "bcadef"));
	}
}
