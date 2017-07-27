package ctci.chapter03.question01_ThreeInOne;

public class FixedMultiStack {
	private int numberOfStack = 3;
	private int stackCapacity;
	private int[] stackValues;
	private int[] stackSizes;

	/**
	 * 
	 * @param stackSize: Stack capacity for each stack
	 */
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		stackValues = new int[numberOfStack * stackCapacity];
		stackSizes = new int[numberOfStack];
	}

	/**
	 * 
	 * @param stackNumber:
	 *            Stack number to push. Start with 0
	 * @param value:
	 *            Value to push
	 */
	public void push(int stackNumber, int value) {
		if (isFull(stackNumber)) {
			throw new Error("The stack is already full!");
		}
		stackSizes[stackNumber]++;
		int index = indexOfLast(stackNumber);
		stackValues[index] = value;
	}

	/**
	 * 
	 * @param stackNumber:
	 *            Stack number to push. Start with 0
	 * @return the top value of the indicated stack
	 */
	public int pop(int stackNumber) {
		if (isEmpty(stackNumber)) {
			throw new Error("The stack is empty!");
		}
		int index = indexOfLast(stackNumber);
		int last = stackValues[index];
		stackSizes[stackNumber]--;
		return last;
	}

	/**
	 * 
	 * @param stackNumber:
	 *            Stack number to push. Start with 0
	 * @return the top value of the indicated stack
	 */
	public int peek(int stackNumber) {
		if (isEmpty(stackNumber)) {
			throw new Error("The stack is empty!");
		}
		int index = indexOfLast(stackNumber);
		return stackValues[index];
	}

	/**
	 * 
	 * @param stackNumber:
	 *            Stack number to push. Start with 0
	 * @return true if the indicated stack is empty, false otherwise
	 */
	public boolean isEmpty(int stackNumber) {
		return stackSizes[stackNumber] == 0;
	}

	/**
	 * 
	 * @param stackNumber:
	 *            Stack number to push. Start with 0
	 * @return true if the indicated stack is full, false otherwise
	 */
	public boolean isFull(int stackNumber) {
		return stackSizes[stackNumber] == stackCapacity;
	}

	/**
	 * 
	 * @param stackNumber:
	 *            Stack number to check. Start with 0
	 * @return: index of the top
	 */
	public int indexOfLast(int stackNumber) {
		int index = stackNumber * numberOfStack;
		int size = stackSizes[stackNumber];
		return index + size - 1;
	}
}
