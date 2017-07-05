package ctci.chapter01.question09_StringRotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question09Test {
	
	@Test
	public void testDifferentLength() {
		String original = "abcd";
		String distored = "bcd";
		assertFalse(Question09Answer.isStringRotation(original, distored));
	}

	@Test
	public void testOriginalNull() {
		String original = "";
		String distored = "abc";
		assertFalse(Question09Answer.isStringRotation(original, distored));
	}
	
	@Test 
	public void testTrueRotation() {
		String original = "stringrotation";
		String distored = "rotationstring";
		assertTrue(Question09Answer.isStringRotation(original, distored));
	}
	
	@Test
	public void testNonRotation() {
		String original = "string";
		String distored = "sringt";
		assertFalse(Question09Answer.isStringRotation(original, distored));
	}

}
