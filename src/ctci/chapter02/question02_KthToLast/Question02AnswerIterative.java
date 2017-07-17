package ctci.chapter02.question02_KthToLast;

import ctci.chapter02.LinkedListNode;

public class Question02AnswerIterative {
	public static LinkedListNode returnKthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		int i = 0;
		while (i < k) {
			p2 = p2.next;
			i++;
		}
		while(p2 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(0, null);
		for (int i = 1; i < 10; i++) {
			LinkedListNode newNode = new LinkedListNode(i, head);
			head = newNode;
		}
		System.out.println(head.print());
		LinkedListNode result = returnKthToLast(head, 4);
		System.out.println(result.data);
	}
}
