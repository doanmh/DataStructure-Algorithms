package ctci.chapter02.question08_LoopDetection;

import ctci.chapter02.LinkedListNode;

public class Question08Answer {
	public static LinkedListNode detectLoop(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(9, null);
		LinkedListNode tail = head;
		for (int i = 8; i >= 6; i--) {
			LinkedListNode newNode = new LinkedListNode(i, head);
			head = newNode;
		}
		LinkedListNode loop = new LinkedListNode(5, head);
		head = loop;
		tail.next = loop;
		tail = loop;
		for (int i = 4; i >= 1; i--) {
			LinkedListNode newNode = new LinkedListNode(i, head);
			head = newNode;
		}
		System.out.println(detectLoop(head).data);
	}
}
