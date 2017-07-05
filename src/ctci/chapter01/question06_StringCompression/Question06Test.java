package ctci.chapter01.question06_StringCompression;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question06Test {

	@Test
	public void testUpperCase() {
		assertEquals(Question06Answer.compressString("AABBCCCEE"), "A2B2C3E2");
	}
	
	@Test
	public void testLowerCase() {
		assertEquals(Question06Answer.compressString("aaabbbcccdeee"), "a3b3c3d1e3");
	}
	
	@Test
	public void testMixCases() {
		assertEquals(Question06Answer.compressString("AAAAbbbCCCdd"), "A4b3C3d2");
	}
	
	@Test
	public void testLongerCompress() {
		assertEquals(Question06Answer.compressString("AbcDef"), "AbcDef");
	}
}
