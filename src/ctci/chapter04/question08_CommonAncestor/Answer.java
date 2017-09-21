package ctci.chapter04.question08_CommonAncestor;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Answer {
	public static boolean search(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return search(root.left, p) || search(root.right, p);
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!search(root, p) || !search(root, q)) {
			return null;
		}
		return commonAncestorSearch(root, p, q);
	}
	
	public static TreeNode commonAncestorSearch(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		
		boolean pLeft = search(root.left, p);
		boolean qLeft = search(root.left, q);
		if (pLeft != qLeft) {
			return root;
		}
		TreeNode toGo = pLeft ? root.left : root.right;
		return commonAncestorSearch(toGo, p, q);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		TreeNode solution = commonAncestor(root, root.left.left, root.right.right.right);
		System.out.println(solution == root);
	}
}
