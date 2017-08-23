package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum508 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int maxCount = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		findFrequentTreeHelper(root, hm);
		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == maxCount) {
				list.add(entry.getKey());
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private int findFrequentTreeHelper(TreeNode root, HashMap<Integer, Integer> hm) {
		if (root == null) {
			return 0;
		}
		int sum = root.val;
		sum += findFrequentTreeHelper(root.left, hm);
		sum += findFrequentTreeHelper(root.right, hm);
		hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		maxCount = Math.max(maxCount, hm.get(sum));
		return sum;
	}
}
