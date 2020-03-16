package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 9:57
 * @Descripton :
 * <p>
 * Convert BST to Greater Tree
 * <p>
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 */
public class SolutionNo538 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int index = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			convertBST2(root);
			return root;
		}
		return null;
	}

	public void convertBST2(TreeNode root) {
		if (root != null) {
			convertBST2(root.right);
			index += root.val;
			root.val = index;
			convertBST2(root.left);
		}
	}

	public static void main(String[] args) {

	}
}
