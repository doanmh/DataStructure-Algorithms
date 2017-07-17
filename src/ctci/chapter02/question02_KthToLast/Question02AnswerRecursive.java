package ctci.chapter02.question02_KthToLast;

import ctci.chapter02.LinkedListNode;

public class Question02AnswerRecursive {
	public static LinkedListNode returnKthToLast(LinkedListNode head, int k) {
		Index index = new Index();
		return returnKthToLast(head, k, index);
	}
	
	public static LinkedListNode returnKthToLast(LinkedListNode head, int k, Index index) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = returnKthToLast(head.next, k, index);
		index.value++;
		if (index.value == k) {
			return head;
		}
		return node;
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
	
	public static class Index {
		public int value = 0;
	}
}
