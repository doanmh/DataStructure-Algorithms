package ctci.chapter03.question05_SortStack;

import java.util.Stack;

public class Question05Answer {
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!stack.empty()) {
			tempStack.push(stack.pop());
		}
		while(!tempStack.empty()) {
			int valueToPush = tempStack.pop();
			if (stack.empty()) {
				stack.push(valueToPush);
			} else {
				while(!stack.empty() && stack.peek() > valueToPush) {
					tempStack.push(stack.pop());
				}
				stack.push(valueToPush);
			}
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			stack.push((int)(Math.random()*10+1));
		}
		sortStack(stack);
		while(!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
