package ctci.chapter01.question04;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question04Test {

	@Test
	public void testInvalidChar() {
		assertFalse(Ch01_Q04_PalindromePermutation.isPalindromePermutation("AABBCC"));
	}
	
	@Test
	public void testCorrectCase() {
		assertTrue(Ch01_Q04_PalindromePermutation.isPalindromePermutation("aabbccddeeffg"));
	}
	
	@Test 
	public void testIncorrectCase() {
		assertFalse(Ch01_Q04_PalindromePermutation.isPalindromePermutation("aabbccddeeefff"));
	}
}
