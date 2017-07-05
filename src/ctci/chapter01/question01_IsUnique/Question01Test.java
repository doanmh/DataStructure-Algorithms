package ctci.chapter01.question01_IsUnique;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;

public class Question01Test {

	@Test
	public void testLength() {
		SecureRandom random = new SecureRandom();
		String randomString = new BigInteger(512, random).toString(256);
		assertFalse(Question01Answer.isUnique(randomString));
	}
	
	@Test
	public void testNonUnique() {
		String testStr = "abcdefghii";
		assertFalse(Question01Answer.isUnique(testStr));
	}
	
	@Test
	public void testUnique() {
		String testStr = "abcdefghi";
		assertTrue(Question01Answer.isUnique(testStr));
	}

}
