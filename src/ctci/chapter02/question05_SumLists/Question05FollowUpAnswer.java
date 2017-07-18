package ctci.chapter02.question05_SumLists;

import ctci.chapter02.LinkedListNode;

public class Question05FollowUpAnswer {
	public static LinkedListNode addLists(LinkedListNode node1, LinkedListNode node2) {
		int length1 = checkLength(node1);
		int length2 = checkLength(node2);
		if (length1 < length2) {
			node1 = equalList(node1, length2 - length1);
		} else {
			node2 = equalList(node2, length1 - length2);
		}
		PartialSum resultSum = addListsHelper(node1, node2);
		LinkedListNode result = resultSum.sum;
		if (resultSum.carrier != 0) {
			result = insertBefore(result, resultSum.carrier);
		}
		return result;
	}
	
	public static PartialSum addListsHelper(LinkedListNode node1, LinkedListNode node2) {
		if (node1 == null && node2 == null) {
			return new PartialSum();
		}
		PartialSum sum = addListsHelper(node1.next, node2.next);
		int value = node1.data + node2.data + sum.carrier;
		int digit = value % 10;
		int carrier = value / 10;
		sum.sum = insertBefore(sum.sum, digit);
		sum.carrier = carrier;
		return sum;
	}
	
	public static LinkedListNode equalList(LinkedListNode node, int padding) {
		for (int i = 0; i < padding; i++) {
			node = insertBefore(node, 0);
		}
		return node;
	}
	
	public static int checkLength(LinkedListNode node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
	
	public static LinkedListNode insertBefore(LinkedListNode node, int value) {
		LinkedListNode newNode = new LinkedListNode(value, null);
		if (node != null) {
			newNode.next = node;
		}
		return newNode;
	}
	
	public static void main(String args[]) {
		LinkedListNode head1 = new LinkedListNode(6, null);
		head1 = insertBefore(head1, 1);
		head1 = insertBefore(head1, 7);
		LinkedListNode head2 = new LinkedListNode(2, null);
		head2 = insertBefore(head2, 9);
		LinkedListNode result = addLists(head1, head2);
		
		System.out.println(result.print());
	}
	
	public static class PartialSum {
		public LinkedListNode sum = null;
		public int carrier = 0;
	}
}
