package ctci.chapter03.question04_QueueViaStack;

import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;

public class QueueViaStackTest {

	@Test
	public void testEnqueueDequeue() {
		QueueViaStack<Integer> q = new QueueViaStack<Integer>();
		for (int i = 0; i < 7; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 7; i++) {
			assertTrue(q.dequeue() == i);
		}
	}
	
	@Test (expected = EmptyStackException.class)
	public void testThrowError(){
		QueueViaStack<Integer> q = new QueueViaStack<Integer>();
		for (int i = 0; i < 7; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 7; i++) {
			q.dequeue();
		}
		q.dequeue();
	}
}
