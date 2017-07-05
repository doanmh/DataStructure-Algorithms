package ctci.chapter01.question04_PalindromePermutation;

/**
 * 
 * @author Minh Doan
 * Implementation using frequency array
 * 
 * Time Complexity: O(n) - Space Complexity: O(1) 
 * with n is the length of the string
 * 
 * Assumption: The characters are lower case from a -> z
 * and the input is always valid
 *
 */
public class Question03Answer {
	public static int getCharIndex(char x) {
		if (x < 'a' || x > 'z') {
			return -1;
		}
		int index = x - 'a';
		return 0 + index;
	}

	public static boolean isPalindromePermutation(String str) {
		int odd_count = 0;
		int[] check = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			int currentIndex = getCharIndex(currentChar);
			if (currentIndex == -1) {
				return false;
			}
			check[currentIndex]++;
			if (check[currentIndex] % 2 != 0) {
				odd_count++;
			} else {
				odd_count--;
			}
		}

		return odd_count <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("Zactcoazaza"));
	}
}
