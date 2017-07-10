package ds.linkedlist;

public class LinkedList<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T value_at(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		int i = 0;
		Node<T> currentNode = head;
		while (i < index) {
			currentNode = currentNode.next;
			i++;
		}
		return (T) currentNode.data;
	}

	public void push_front(T value) {
		if (head == null) {
			head = new Node<T>(value, null);
			tail = head;
		} else {
			Node<T> newNode = new Node<T>(value, head);
			head = newNode;
		}
		size++;
	}

	public T pop_front() {
		Node<T> tempNode = head;
		head = head.next;
		size--;
		return tempNode.data;
	}

	public void push_back(T value) {
		if (head == null) {
			push_front(value);
		} else {
			Node<T> newNode = new Node<T>(value, null);
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	public T pop_back() {
		Node<T> tempNode = head;
		while (!tempNode.next.equals(tail)) {
			tempNode = tempNode.next;
		}
		tail = tempNode;
		T data = tail.next.data;
		tail.next = null;
		size--;
		return data;
	}

	public T front() {
		return head.data;
	}

	public T back() {
		return tail.data;
	}

	public void insert(int index, T value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (index == 0) {
			push_front(value);
		} else if (index == size) {
			push_back(value);
		} else {
			int i = 0;
			Node<T> tempNode = head;
			while (i < index - 1) {
				tempNode = tempNode.next;
				i++;
			}
			Node<T> newNode = new Node<T>(value, tempNode.next);
			tempNode.next = newNode;
			size++;
		}
	}

	public void erase(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		if (index == 0) {
			pop_front();
		} else if (index == size) {
			pop_back();
		} else {
			int i = 0;
			Node<T> tempNode = head;
			while (i < index - 1) {
				tempNode = tempNode.next;
				i++;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}

	}

	public T value_n_from_end(int n) {
		int index = size - 1 - n;
		return value_at(index);
	}

	public LinkedList<T> reverse() {
		Node<T> tempNode = head;
		LinkedList<T> list = new LinkedList<T>();
		while (tempNode != null) {
			list.push_front(tempNode.data);
			tempNode = tempNode.next;
		}
		return list;
	}

	public void remove_value(T value) {
		int i = 0;
		Node<T> tempNode = head;
		while (i < size) {
			if (tempNode.data.equals(value)) {
				erase(i);
				return;
			}
			tempNode = tempNode.next;
			i++;
		}
	}
}
