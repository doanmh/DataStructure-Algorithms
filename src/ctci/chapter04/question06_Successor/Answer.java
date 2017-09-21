package ctci.chapter04.question06_Successor;

class TreeNode {
	int val;
	TreeNode parent = null;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode (int x, TreeNode p) {
		parent = p;
		val = x;
	}
}

public class Answer {
	public static TreeNode findSuccessor(TreeNode n) {
		if (n.right != null) {
			return findLeftMost(n.right);
		}
		TreeNode q = n.parent;
		TreeNode x = q.parent;
		while (x != null && x.left != q) {
			q = x;
			x = x.parent;
		}
		return x;
	}
	
	public static TreeNode findLeftMost(TreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5, null);
		root.left = new TreeNode(3, root);
		root.right = new TreeNode(7, root);
		root.left.left = new TreeNode(1, root.left);
		root.left.right = new TreeNode(2, root.left);
		root.right.left = new TreeNode(6, root.right);
		root.right.right = new TreeNode(8, root.right);
		System.out.println(findSuccessor(root.left.right).val);
	}
}
