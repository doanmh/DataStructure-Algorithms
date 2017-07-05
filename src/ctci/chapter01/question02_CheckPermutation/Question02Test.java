package ctci.chapter01.question02_CheckPermutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question02Test {

	@Test
	public void testNotEqualLength() {
		String str1 = "abcdefgh";
		String str2 = "cabfedghiqre";
		assertFalse(Question02Answer.checkPermutation(str1, str2));
	}
	
	@Test
	public void testTruePermutation() {
		String str1 = "to be or not to be";
		String str2 = "not to be or to be";
		assertTrue(Question02Answer.checkPermutation(str1, str2));
	}
	
	@Test
	public void testNonPermutation() {
		String str1 = "1234";
		String str2 = "abcd";
		assertFalse(Question02Answer.checkPermutation(str1, str2));
	}

}
