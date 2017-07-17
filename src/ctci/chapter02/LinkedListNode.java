package ctci.chapter02;

public class LinkedListNode {
	public LinkedListNode next = null;
	public int data;
	
	public LinkedListNode(int data, LinkedListNode next) {
		this.data = data;
		this.next = next;
	}
	
	public String print() {
		if (next != null) {
			return data + "->" + next.print();
		} else {
			return ((Integer) data).toString();
		}
	}
}
