package ctci.chapter02.question03_DeleteMiddleNode;

import ctci.chapter02.LinkedListNode;

public class Question03Answer {
	public static boolean deleteNode(LinkedListNode node) {
		if (node.next == null || node == null) {
			return false;
		}
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(0, null);
		for (int i = 1; i < 10; i++) {
			LinkedListNode newNode = new LinkedListNode(i, head);
			head = newNode;
		}
		LinkedListNode runner = head;
		for (int i = 1; i < 5; i++) {
			runner = runner.next;
		}
		if(deleteNode(runner)) {
			System.out.println(head.print());
		} else {
			System.out.println("Error");
		}
	}
}
