package ctci.chapter02.question04_Partition;

import ctci.chapter02.LinkedListNode;

public class Question04Answer {
	public static LinkedListNode partition(LinkedListNode head, int x) {
		LinkedListNode first = head;
		LinkedListNode last = head;
		while (head != null) {
			LinkedListNode next = head.next;
			if (head.data < x) {
				head.next = first;
				first = head;
			} else {
				last.next = head;
				last = head;
			}
			head = next;
		}
		last.next = null;
				
		return first;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode((int) (Math.random()*10), null);
		for (int i = 1; i < 10; i++) {
			LinkedListNode newNode = new LinkedListNode((int) (Math.random()*10), head);
			head = newNode;
		}
		System.out.println(head.print());
		LinkedListNode node = partition(head, 6);
		System.out.println(node.print());
	}
}
