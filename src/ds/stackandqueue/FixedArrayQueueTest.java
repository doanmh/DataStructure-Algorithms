package ds.stackandqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixedArrayQueueTest {

	@Test(expected = Error.class)
	public void testEnqueueFull() {
		FixedArrayQueue<Integer> queue = new FixedArrayQueue<Integer>(5);
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		queue.enqueue(6);
	}
	
	@Test(expected = Error.class)
	public void testEnqueueDequeue() {
		FixedArrayQueue<String> queue = new FixedArrayQueue<String>(5);
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		assertTrue(queue.full());
		queue.dequeue();
		queue.enqueue("f");
		String firstValue = queue.dequeue();
		assertEquals(firstValue, "b");
		queue.enqueue("g");
		queue.enqueue("h");
	}
}
