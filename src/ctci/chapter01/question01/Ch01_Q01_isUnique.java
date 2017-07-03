package ctci.chapter01.question01;

/**
 * 
 * @author Minh Doan
 * Implementation using check array
 * 
 * Time Complexity: O(n) - Space Complexity: O(1)
 * 
 * Assumption: The characters are ASCII characters and the input is valid
 *
 */
public class Ch01_Q01_isUnique {
	public static boolean isUnique(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] check = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i);
			if (check[index]) {
				return false;
			} else {
				check[index] = true;
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		System.out.println(isUnique("abcdef"));
	}
}
