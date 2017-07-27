package leetcode.linkedlist;

public class ReverseNodesInKGroup25 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode anchor = dummy;
		ListNode slow = head;
		ListNode fast = head;
		ListNode tail = null;
		for (int i = 0; i < k; i++) {
			if (fast == null) {
				break;
			}
			fast = fast.next;
		}
		while (slow != null) {
			if (tail == null) {
				tail = slow;
				anchor.next = tail;
				slow = slow.next;
				tail.next = null;
			} else {
				ListNode temp = slow.next;
				slow.next = anchor.next;
				anchor.next = slow;
				slow = temp;
			}
			if (slow == fast) {
				
				anchor = tail;
				
				tail = null;
				for (int i = 0; i < k; i++) {
					if (fast == null) {
						anchor.next = slow;
						slow = null;
						break;
					}
					fast = fast.next;
				}
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i = 2; i < 7; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		head = reverseKGroup(head, 3);
		temp = head;
		for (int i = 0; i < 5; i++) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println(temp.val);
	}
}
