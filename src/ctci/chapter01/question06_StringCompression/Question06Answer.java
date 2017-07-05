package ctci.chapter01.question06_StringCompression;

public class Question06Answer {
	public static String compressString(String str) {
	    int count = 0;
	    StringBuilder compress = new StringBuilder();
	    for (int i = 0; i < str.length(); i++) {
	    	count++;
	        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
	        	compress.append(str.charAt(i));
	        	compress.append(count);
	        	count = 0;
	        }
	    }
	    return str.length() > compress.length() ? compress.toString() : str;
	}
	
	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
	}
}
