package ctci.chapter02.question06_Palindrome;

import java.util.Stack;

import ctci.chapter02.LinkedListNode;

public class Question06Answer {
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> firstHalf = new Stack<>();
		while (fast != null && fast.next != null) {
			firstHalf.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null) {
			return palindromeHelper(firstHalf, slow);
		}
		return palindromeHelper(firstHalf, slow.next);
	}
	
	public static boolean palindromeHelper(Stack<Integer> firstHalf, LinkedListNode secondHalf) {
		while (secondHalf != null) {
			if (firstHalf.pop() != secondHalf.data) {
				return false;
			}
			secondHalf = secondHalf.next;
		}
		return true;
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
	
	public static void main(String[] args) {
		int[] llist = {1, 4, 6, 4 ,1};
		LinkedListNode head = arrayToLinkedList(llist);
		System.out.println(head.print());
		System.out.println(isPalindrome(head));
	}
}
