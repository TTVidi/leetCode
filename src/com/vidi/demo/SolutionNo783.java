package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 11:24
 * @Descripton :
 * <p>
 * Minimum Distance Between BST Nodes
 * <p>
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two
 * different nodes in the tree.
 */
public class SolutionNo783 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int min = Integer.MAX_VALUE;
	int prev = Integer.MIN_VALUE;

	public int minDiffInBST(TreeNode root) {
		if (root != null) {
			minDiffInBST(root);
			return min;
		}
		return 0;
	}

	public void minDiffInBST2(TreeNode root) {
		if (root != null) {
			minDiffInBST2(root.left);
			if (prev != Integer.MIN_VALUE) {
				min = min < root.val - prev ? min : root.val - prev;
			}
			prev = root.val;
			minDiffInBST2(root.right);
		}
	}

}


