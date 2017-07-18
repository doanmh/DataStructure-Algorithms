package ctci.chapter02.question05_SumLists;

import ctci.chapter02.LinkedListNode;

public class Question05Answer {
	public static LinkedListNode sumLists(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode list1 = head1;
		LinkedListNode list2 = head2;
		LinkedListNode result = null;
		LinkedListNode tail = result;
		int carrier = 0; int digit = 0;
		while (list1 != null || list2 != null) {
			int value = carrier;
			if (list1 != null) {
				value += list1.data;
				list1 = list1.next;	
			}
			if (list2 != null) {
				value += list2.data;
				list2 = list2.next;
			}
			digit = value % 10;
			carrier = value / 10;
			LinkedListNode newNode = new LinkedListNode(digit, null);
			if (result == null) {
				result = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedListNode head1 = new LinkedListNode(6, null);
		head1 = new LinkedListNode(1, head1);
		head1 = new LinkedListNode(7, head1);
		LinkedListNode head2 = new LinkedListNode(2, null);
		head2 = new LinkedListNode(9, head2);
		LinkedListNode result = sumLists(head2, head1);
		System.out.println(result.print());
	}
}
