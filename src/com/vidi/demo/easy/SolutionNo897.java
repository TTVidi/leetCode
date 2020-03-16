package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/12/6 11:23
 * @Descripton :
 * <p>
 * Increasing Order Search Tree <p>Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is
 * now the root of the tree, and every node has no left child and only 1 right child.
 * <p>
 * Example 1: Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5 / \ 3    6 / \    \ 2   4    8 /        / \ 1        7   9
 * <p>
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6 \ 7 \ 8 \ 9 Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 100. Each node will have a unique integer value from 0 to
 * 1000.
 */
public class SolutionNo897 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode increasingBST(TreeNode root) {
		List<Integer> middleSort = middleSort(root, new ArrayList<>());
		if (middleSort == null) {
			return null;
		}
		root = new TreeNode(middleSort.get(0));
		TreeNode parent = root;
		parent.left = null;
		TreeNode child;
		for (int i = 1; i < middleSort.size(); i++) {
			child = new TreeNode(middleSort.get(i));
			child.left = null;
			parent.right = child;
			parent = child;
		}
		return root;
	}

	public static List<Integer> middleSort(TreeNode root, List<Integer> list) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return list;
		}
		if (root.left != null) {
			middleSort(root.left, list);
		}
		list.add(root.val);
		if (root.right != null) {
			middleSort(root.right, list);
		}
		return list;
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

		increasingBST(s_1);
	}


}
