package ctci.chapter04.question04_CheckBalance;

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

public class Answer1 {
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static boolean checkBalance(TreeNode root) {
		if (root == null) {
			return true;
		}
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		if (Math.abs(lh - rh) <= 1 && checkBalance(root.left) && checkBalance(root.right)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(checkBalance(root));
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		System.out.println(checkBalance(root1));
	}
}
