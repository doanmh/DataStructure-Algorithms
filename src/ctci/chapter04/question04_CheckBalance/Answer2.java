package ctci.chapter04.question04_CheckBalance;

public class Answer2 {
	private static int checkBalance(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lh = checkBalance(root.left);
		if (lh == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		int rh = checkBalance(root.right);
		if (rh == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (Math.abs(lh - rh) > 1) {
			return Integer.MIN_VALUE;
		} 
		return Math.max(rh, lh) + 1;		
	}
	
	public static boolean isBalance(TreeNode root) {
		return checkBalance(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(isBalance(root));
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		System.out.println(isBalance(root1));
	}
}
