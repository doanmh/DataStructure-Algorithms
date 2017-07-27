package ctci.chapter03.question02_StackMin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackMinTest {

	@Test
	public void test() {
		StackMin stack = new StackMin();
		stack.push(3);
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(1);
		assertEquals(stack.min(), 1);
		stack.pop();
		assertEquals(stack.min(), 1);
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(stack.min(), 3);
	}
}
