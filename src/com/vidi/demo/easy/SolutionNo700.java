package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/28 16:28
 * @Descripton :
 * <p>
 * Search in a Binary Search Tree
 * <p>
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's
 * value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return
 * NULL.
 * <p>
 * For example,
 * <p>
 * Given the tree: 4 / \ 2   7 / \ 1   3
 * <p>
 * And the value to search: 2 You should return this subtree:
 * <p>
 * 2 / \ 1   3 In the example above, if we want to search the value 5, since there is no node with value 5, we should
 * return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format)
 * as [], not null.
 */
public class SolutionNo700 {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
	 * x) { val = x; } }
	 */

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		}
		return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
	}

	public static void main(String[] args) {
		TreeNode s_3_1 = new TreeNode(1);
		s_3_1.left = null;
		s_3_1.right = null;

		TreeNode s_3_2 = new TreeNode(3);
		s_3_2.left = null;
		s_3_2.right = null;

		TreeNode s_2_1 = new TreeNode(2);
		s_2_1.left = s_3_1;
		s_2_1.right = s_3_2;

		TreeNode s_2_2 = new TreeNode(7);
		s_2_2.left = null;
		s_2_2.right = null;

		TreeNode s_1 = new TreeNode(4);
		s_1.left = s_2_1;
		s_1.right = s_2_2;

		TreeNode treeNode = searchBST(s_1, 2);
		if (treeNode != null) {
			System.out.println(treeNode.val);
		} else {
			System.out.println("null");
		}
	}
}
