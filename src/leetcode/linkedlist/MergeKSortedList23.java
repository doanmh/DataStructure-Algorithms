package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList23 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		if (len == 0 || lists == null) {
			return null;
		}
		if (len == 1) {
			return lists[0];
		}
		PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return Integer.compare(l1.val, l2.val);
			}
		});
		for (int i = 0; i < len; i++) {
			if (lists[i] != null) {
				pQueue.add(lists[i]);
			}
		}
		ListNode head = null;
		ListNode tail = null;
		while (!pQueue.isEmpty()) {
			ListNode temp = pQueue.poll();
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}
			if (temp.next != null) {
				pQueue.add(temp.next);
			}
		}
		return head;
	}
}
