package ctci.chapter01.question05_OneAway;

/*
 * This way is not optimal. Need to revise
 */

public class Question05Answer {
	public static int getCharIndex(char x) {
	    if (x < 'a' || x > 'z') {
	        return -1;
	    }
	    int index = x - 'a';
	    return 0 + index;
	}

	public static boolean isOneAway(String str1, String str2) {
	    int diff_count = 0;
	    int length1 = str1.length();
	    int length2 = str2.length();
	    int length_diff = Math.abs(length1 - length2);
	    if (length_diff >= 2) {
	        return false;
	    }
	    int[] freq = new int[26];
	    for (int i = 0; i < length1; i++) {
	        char currentChar = str1.charAt(i);
	        int currentIndex = getCharIndex(currentChar);
	        freq[currentIndex]++;
	    }
	    for (int i = 0; i < length2; i++) {
	        char currentChar = str2.charAt(i);
	        int currentIndex = getCharIndex(currentChar);
	        if (freq[currentIndex] == 0) {
	            diff_count++;
	        } else {
	            freq[currentIndex]--;
	        }
	    }
	    return diff_count + length_diff <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "ple"));
		System.out.println(isOneAway("pales", "pale"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("pale", "bake"));
	}
}
