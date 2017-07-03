package ctci.chapter01.question01;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;

public class Question01Test {

	@Test
	public void testLength() {
		SecureRandom random = new SecureRandom();
		String randomString = new BigInteger(512, random).toString(256);
		assertFalse(Ch01_Q01_isUnique.isUnique(randomString));
	}
	
	@Test
	public void testNonUnique() {
		String testStr = "abcdefghii";
		assertFalse(Ch01_Q01_isUnique.isUnique(testStr));
	}
	
	@Test
	public void testUnique() {
		String testStr = "abcdefghi";
		assertTrue(Ch01_Q01_isUnique.isUnique(testStr));
	}

}
