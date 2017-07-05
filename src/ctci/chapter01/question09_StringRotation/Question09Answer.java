package ctci.chapter01.question09_StringRotation;

public class Question09Answer {
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) > -1) {
			return true;
		}
		return false;
	}
	
	public static boolean isStringRotation(String original, String distored) {
		if (original.length() != distored.length() || original.length() < 0) {
			return false;
		}
		StringBuilder doubleOriginal = new StringBuilder(2*original.length());
		doubleOriginal.append(original);
		doubleOriginal.append(original);
		if (isSubstring(doubleOriginal.toString(), distored)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String original = "waterbottle";
		String distored = "erbottlewat";
		System.out.println(isStringRotation(original, distored));
		original = "apple";
		distored = "plpea";
		System.out.println(isStringRotation(original, distored));
	}
}

