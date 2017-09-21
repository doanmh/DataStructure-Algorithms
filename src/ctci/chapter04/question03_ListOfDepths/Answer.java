package ctci.chapter04.question03_ListOfDepths;

import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class Answer {
	public static void createList(TreeNode t, LinkedList<TreeNode> arr[], int level) {
		if (t == null) {
			return;
		}
		if (arr[level] == null) {
			arr[level] = new LinkedList<TreeNode>();
		}
		arr[level].add(t);
		createList(t.left, arr, level+1);
		createList(t.right, arr, level+1);
		return;
	}
	
	public static TreeNode createTree(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode t = new TreeNode(arr[mid]);
		t.left = createTree(arr, start, mid-1);
		t.right = createTree(arr, mid+1, end);
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		int nodes[] = {1,2,3,4,5,6,7,8,9};
		LinkedList<TreeNode> arr[] = new LinkedList[4];
		TreeNode root = createTree(nodes, 0, nodes.length-1);
		createList(root, arr, 0);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < arr[i].size(); j++) {
				System.out.print(arr[i].get(j).val + " ");
			}
			System.out.println();
		}
	}
}
