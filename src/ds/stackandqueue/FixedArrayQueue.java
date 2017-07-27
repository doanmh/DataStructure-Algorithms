package ds.stackandqueue;

public class FixedArrayQueue<T> {
	
	private Object[] queue;
	private int read, write, size;
	
	public FixedArrayQueue(int s) {
		size = s + 1;
		queue = new Object[size];
		read = 0;
		write = 0;
	}
	
	public void enqueue(T value) {
		if (full()) {
			throw new Error("Queue is full!");
		}
		queue[write] = value;
		write++;
		if (write > size - 1) {
			write = 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (empty()) {
			throw new Error("Queue is empty!");
		}
		T result = (T)queue[read];
		read++;
		if (read > size -1) {
			read = 0;
		}
		return result;
	}
	
	public boolean full() {
		if (read - write == 1 || (read == 0 && write == size-1)) {
			return true;
		}
		return false;
	}
	
	public boolean empty() {
		return write == read;
	}
}
