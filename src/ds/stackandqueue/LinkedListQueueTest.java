package ds.stackandqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListQueueTest {

	@Test
	public void testEnqueueDequeue() {
		LinkedListQueue<String> queue = new LinkedListQueue<String>();
		queue.enqueue("Minh");
		queue.enqueue("Anh");
		queue.enqueue("Doan");
		String firstValue = queue.dequeue();
		assertEquals(firstValue, "Minh");
	}

	@Test
	public void testEmpty() {
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		assertFalse(queue.empty());
		for (int i = 0; i < 3; i++) {
			queue.dequeue();
		}
		assertTrue(queue.empty());
	}
	
	@Test
	public void testEmpty1() {
		LinkedListQueue<String> queue = new LinkedListQueue<String>();
		assertTrue(queue.empty());
	}
}
