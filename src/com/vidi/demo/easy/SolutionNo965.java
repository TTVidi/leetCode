package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/1/7 10:09
 * @Descripton :
 * <p>
 * Univalued Binary Tree
 * <p>
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 */
public class SolutionNo965 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean result = true;

	public boolean isUnivalTree(TreeNode root) {
		if (!result) {
			return result;
		}
		if (root.left != null) {
			if (root.left.val == root.val) {
				isUnivalTree(root.left);
			} else {
				result = false;
			}
		}

		if (root.right != null) {
			if (root.right.val == root.val) {
				isUnivalTree(root.right);
			} else {
				result = false;
			}
		}
		return result;
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

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}


	public static void main(String[] args) {
		TreeNode root = stringToTreeNode("[2,2,2,5,2]");

		boolean ret = new SolutionNo965().isUnivalTree(root);

		String out = booleanToString(ret);

		System.out.print(out);
	}
}
