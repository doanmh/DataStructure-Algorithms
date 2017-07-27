package ctci.chapter03.question01_ThreeInOne;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixedMultiStackTest {

	@Test(expected = Error.class)
	public void testFull() {
		FixedMultiStack stack = new FixedMultiStack(5);
		for (int i = 0; i < 5; i++) {
			stack.push(0, i);
		}
		stack.push(0, 5);
	}
	
	@Test
	public void testPushPop() {
		FixedMultiStack stack = new FixedMultiStack(5);
		stack.push(1, 20);
		stack.push(1, 10);
		stack.push(0, 34);
		stack.push(0, 15);
		stack.push(0, 20);
		int value = stack.pop(1);
		assertEquals(value, 10);
		int value2 = stack.pop(0);
		assertEquals(value2, 20);
		assertTrue(stack.isEmpty(2));
	}

}
