package ctci.chapter03.question03_StackOfPlates;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackPlate {
	@SuppressWarnings("rawtypes")
	private ArrayList<Stack> stacks = new ArrayList<Stack>();
	private int threshold;
	
	public StackPlate(int threshold) {
		this.threshold = threshold;
	}
	
	public void push(int value) {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack != null && lastStack.size() < threshold) {
			lastStack.push(value);
		} else {
			lastStack = new Stack<Integer>();
			lastStack.push(value);
			stacks.add(lastStack);
		}
	}
	
	public int pop() {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack == null) {
			throw new EmptyStackException();
		} 
		int value = lastStack.pop();
		if (lastStack.empty()) {
			stacks.remove(lastStack);
		}
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public Stack<Integer> getLastStack() {
		if (!stacks.isEmpty()) {
			return stacks.get(stacks.size() - 1);
		}
		return null;
	}
}