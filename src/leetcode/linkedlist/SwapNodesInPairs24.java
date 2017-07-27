package leetcode.linkedlist;

public class SwapNodesInPairs24 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode swapPairs(ListNode node) {
        ListNode head = node;
        ListNode prev = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        boolean firstNode = true;
        ListNode fast = head.next.next;
        while (head != null) {
            if (firstNode) {
                node = head.next;
                firstNode = false;
                prev = head;
            } else {
                prev.next = head.next;
                prev = head;
            }
            head.next.next = head;
            head.next = fast;
            head = head.next;
            if (fast == null || fast.next == null) {
                return node;
            }
            fast = fast.next.next;
        }
        return node;
    }
}
