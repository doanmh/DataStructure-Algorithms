package ctci.chapter01.question04_PalindromePermutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question04Test {

	@Test
	public void testInvalidChar() {
		assertFalse(Question03Answer.isPalindromePermutation("AABBCC"));
	}
	
	@Test
	public void testCorrectCase() {
		assertTrue(Question03Answer.isPalindromePermutation("aabbccddeeffg"));
	}
	
	@Test 
	public void testIncorrectCase() {
		assertFalse(Question03Answer.isPalindromePermutation("aabbccddeeefff"));
	}
}
