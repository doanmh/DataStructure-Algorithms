package ctci.chapter03.question03_StackOfPlates;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackPlateTest {

	@Test
	public void testPushPop() {
		StackPlate st = new StackPlate(3);
		for (int i = 0; i < 10; i++) {
			st.push(i);
		}
		assertEquals(st.pop(), 9);
		assertEquals(st.pop(), 8);
	}

}
