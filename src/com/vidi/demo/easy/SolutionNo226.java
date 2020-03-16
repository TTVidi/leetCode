package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/24 17:35
 * @Descripton :
 * <p>
 * Invert Binary Tree
 * <p>
 */
public class SolutionNo226 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
