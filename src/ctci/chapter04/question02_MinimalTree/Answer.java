package ctci.chapter04.question02_MinimalTree;

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
	
	public static void inOrder(TreeNode t) {
		if (t == null) {
			return;
		}
		inOrder(t.left);
		System.out.println(t.val);
		inOrder(t.right);
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6};
		TreeNode root = createTree(arr, 0, arr.length-1);
		inOrder(root);
	}
}
