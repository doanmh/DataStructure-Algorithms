package ctci.chapter02.question01_RemoveDuplicates;

import java.util.HashSet;

import ctci.chapter02.LinkedListNode;

public class Question01Answer {
	public static void removeDuplicates(LinkedListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode current = head;
		LinkedListNode previous = null;
		while(current != null) {
			if (!set.contains(current.data)) {
				set.add(current.data);
				previous = current;
			} else {
				previous.next = current.next;
			}	
			current = current.next;
		}
	}
	
	public static void removeDuplicatesNoBuffer(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode runner = current.next;
			LinkedListNode previous = current;
			while (runner != null) {
				if (current.data == runner.data) {
					previous.next = runner.next;
				} else {
					previous = runner;
				}
				runner = runner.next;
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(0, null);
		LinkedListNode headNoBuffer = new LinkedListNode(0, null);
		for (int i = 1; i < 10; i++) {
			LinkedListNode newNode = new LinkedListNode(i%3, head);
			LinkedListNode newNodeNoBuffer = new LinkedListNode(i%3, headNoBuffer);
			head = newNode;
			headNoBuffer = newNodeNoBuffer;
		}
		System.out.println("Buffer: " + head.print());
		System.out.println("No buffer: " + headNoBuffer.print());
		removeDuplicates(head);
		removeDuplicatesNoBuffer(headNoBuffer);
		System.out.println("Buffer: " + head.print());
		System.out.println("No buffer: " + headNoBuffer.print());
	}
}
