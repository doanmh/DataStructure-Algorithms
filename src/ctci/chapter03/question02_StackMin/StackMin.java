package ctci.chapter03.question02_StackMin;

import java.util.Stack;

public class StackMin {
	Stack<Integer> stack = null;
	Stack<Integer> minStack = null;
	
	public StackMin() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (value <= min()) {
			minStack.push(value);
		}
		stack.push(value);
	}
	
	public int pop() {
		if (stack.empty()) {
			throw new Error("Stack is empty!");
		}
		int value = stack.pop();
		if (value == min()) {
			minStack.pop();
		}
		return value;
	}
	
	public int peek() {
		return stack.peek();
	}
	
	public int min() {
		if (minStack.empty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}
}
