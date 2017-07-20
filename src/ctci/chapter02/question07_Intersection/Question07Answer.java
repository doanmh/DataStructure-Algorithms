package ctci.chapter02.question07_Intersection;

import ctci.chapter02.LinkedListNode;

public class Question07Answer {
	public static LinkedListNode intersection(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode node1 = head1;
		LinkedListNode node2 = head2;
		int len1 = 1;
		int len2 = 1;
		// Calculate length
		while (node1.next != null || node2.next != null) {
			if (node1.next != null) {
				len1++;
				node1 = node1.next;
			}
			if (node2.next != null) {
				len2++;
				node2 = node2.next;
			}
		}
		/* 
		 * If the last node is not the same,
		 * then there is no intersection.
		 * 
		 * Return null;	
		 */
		if (node1 != node2) {
			return null;
		}
		/*
		 * Place 2 runner at the head node
		 */
		node1 = head1;
		node2 = head2;
		/*
		 * Move the node with greater length 
		 * to the same position as the the smaller length
		 */
		if (len1 < len2) {
			for (int i = 0; i < len2 - len1; i++) {
				node2 = node2.next;
			}
		} else {
			for (int i = 0; i < len1 - len2; i++) {
				node1 = node1.next;
			}
		}
		/*
		 * Run, if two node are the same
		 * return that node;
		 */
		while (node1 != null && node2 != null) {
			if (node1 == node2) {
				return node1;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return null;
	}
	
	public static LinkedListNode arrayToLinkedList(int[] array) {
		int len = array.length;
		if (len == 0) {
			return null;
		}
		LinkedListNode head = new LinkedListNode(array[len-1], null);
		for (int i = len-2; i >=0; i--) {
			LinkedListNode newNode = new LinkedListNode(array[i], head);
			head = newNode;
		}
		return head;
	}
	
	public static LinkedListNode insertBefore(LinkedListNode node, int[] value) {
		int len = value.length;
		for (int i = len-1; i >= 0; i--) {
			LinkedListNode newNode = new LinkedListNode(value[i], null);
			if (node != null) {
				newNode.next = node;
				node = newNode;
			}
		}
		return node;
	}
	
	public static void main(String[] args) {
		int[] common = {7, 2, 1};
		LinkedListNode head1 = arrayToLinkedList(common);
		LinkedListNode head2 = head1;
		int[] arr1 = {3, 1, 5, 9};
		int[] arr2 = {4, 6};
		head1 = insertBefore(head1, arr1);
		head2 = insertBefore(head2, arr2);
		System.out.println(head2.print());
		System.out.println(head1.print());
		LinkedListNode result = intersection(head1, head2);
		System.out.println(result.data);
	}
}
