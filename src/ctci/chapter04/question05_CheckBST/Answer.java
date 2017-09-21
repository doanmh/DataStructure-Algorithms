package ctci.chapter04.question05_CheckBST;

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
	static Integer last = null;
	
	public static boolean checkBST(TreeNode root, boolean isLeft) {
		if (root == null) {
			return true;
		}
		
		if (!checkBST(root.left, true)) {
			return false;
		}
		
		if (last != null) {
			if (isLeft) {
				if (root.val < last) {
					return false;
				}
			} else {
				if (root.val <= last) {
					return false;
				}
			}
		}
		last = root.val;
		
		if (!checkBST(root.right, false)) {
			return false;
		}
		return true;
	}
	
	public static boolean checkBST2(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		
		if ((max != null && root.val > max) || (min != null && root.val <= min)) {
			return false;
		}
		
		if (!checkBST2(root.left, min, root.val)) {
			return false;
		}
		
		if (!checkBST2(root.right, root.val, max)) {
			return false;
		}
		return true;
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
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.right = new TreeNode(25);
		System.out.println(checkBST(root, true));
		last = null;
		int nodes[] = {1,2,3,4};
		TreeNode root1 = createTree(nodes, 0, nodes.length - 1);
		root.left.val = 2;
		System.out.println(checkBST(root1, true));
		System.out.println(checkBST2(root1, null, null));
	}
}
