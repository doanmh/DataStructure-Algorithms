package ds.stackandqueue;

import ds.linkedlist.LinkedList;

/**
 * 
 * @author Minh Doan
 *
 * This implementation reuse LinkedList class that I implemented earlier
 * with head and tail node
 * 
 */

public class LinkedListQueue<T> {
	private LinkedList<T> queue = new LinkedList<T>();
	
	public void enqueue(T value) {
		queue.push_back(value);
	}
	
	public T dequeue() {
		return (T) queue.pop_front();
	}
	
	public T peek() {
		return (T) queue.front();
	}
	
	public boolean empty() {
		return queue.isEmpty();
	}
}
