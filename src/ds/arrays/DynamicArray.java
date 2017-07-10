package ds.arrays;

import java.util.Arrays;

public class DynamicArray<T> {
	private int size;
	private int capacity;
	private Object[] elementList;
	private static final int MIN_CAPACITY = 16;
	
	public DynamicArray() {
		this(16);
	}
	
	public DynamicArray(int initialCapacity) {
		if (initialCapacity < 16) {
			capacity = 16;
		} else {
			capacity = initialCapacity;
		}
		size = 0;
		elementList = new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	public T at(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is either less than 0 or great ther than size: " + this.size);
		}
		return (T)elementList[index];
	}
	
	public void push(T item) {
		checkForResize(size+1);
		elementList[size] = item;
		size++;
	}
	
	public void insert(int index, T item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is either less than 0 or great ther than size: " + this.size);
		}
		checkForResize(size+1);
		System.arraycopy(elementList, index, elementList, index + 1, size - index);
		elementList[index] = item;
		size++;
 	}
	
	public void prepend(T item) {
		insert(0, item);
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		if (size == 0) {
			throw new Error("There is no item in the array");
		}
		T tempItem = (T)elementList[size-1];
		elementList[size-1] = null;
		size--;
		checkForResize(size);
		return tempItem;
	}
	
	public void delete(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is either less than 0 or great ther than size: " + this.size);
		}
		if (index == size-1) {
			pop();
			return;
		} else {
			System.arraycopy(elementList, index + 1, elementList, index, size - index);
		}
		elementList[size-1] = null;
		this.size--;
		checkForResize(size);
	}
	
	public void remove(T item) {
		for (int i = 0; i < size; i++) {
			if (elementList[i] == item) {
				delete(i);
				i--;
			}
		}
	}
	
	public int find(T item) {
		for (int i = 0; i < size; i++) {
			if (item.equals(elementList[i])) {
				return i;
			}
		}
		return -1;
	}
	
	private void checkForResize(int size) {
		if (size < capacity && size > capacity/4) {
			return;
		}
		if (size <= capacity/4) {
			if (capacity == MIN_CAPACITY) {
				return;
			}
			if (capacity / 2 < MIN_CAPACITY) {
				resize(MIN_CAPACITY);
			} else {
				resize(capacity/2);
			}
		}
		if (size >= capacity) {
			resize(capacity*2);
		}
	}
	
	private void resize(int newCapacity) {
		capacity = newCapacity;
		elementList = Arrays.copyOf(elementList, newCapacity);
	}
}
