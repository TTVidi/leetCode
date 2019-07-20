package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 10:20
 * @Descripton :Given the root node of a binary search tree, return the sum of values of all nodes with value between L
 * and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 */
public class SolutionNo938 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root != null) {
			if (root.val <= R && root.val >= L) {
				return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
			}else {
				return  rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
			}
		}
		return 0;
	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]");
		int L = Integer.parseInt("6");
		int R = Integer.parseInt("10");
		int ret = new SolutionNo938().rangeSumBST(root, L, R);
		String out = String.valueOf(ret);
		System.out.println(out);
	}

}
