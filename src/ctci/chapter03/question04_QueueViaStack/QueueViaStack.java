package ctci.chapter03.question04_QueueViaStack;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueViaStack<T> {
	private Stack<T> s1; 
	private Stack<T> s2; 
	
	public QueueViaStack() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void enqueue(T value) {
		s1.push(value);
	}
	
	public T dequeue() {
		if (s2.empty()) {
			if (s1.empty()) {
				throw new EmptyStackException();
			}
			while (!s1.empty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}
