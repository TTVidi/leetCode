package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2018/12/6 15:34
 * @Descripton :
 * <p>
 * Trim a Binary Search Tree
 * <p>
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements
 * lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of
 * the trimmed binary search tree.
 */
public class SolutionNo669 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static String treeNodeToString(TreeNode root) {
		if (root == null) {
			return "[]";
		}

		String output = "";
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (node == null) {
				output += "null, ";
				continue;
			}

			output += String.valueOf(node.val) + ", ";
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
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

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		if (root.val < L) {
			return trimBST(root.right, L, R);
		}
		if (root.val > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}


	public void main(String[] args) {
		TreeNode root = stringToTreeNode("1,0,2");
		int L = Integer.parseInt("1");
		int R = Integer.parseInt("2");

		TreeNode ret = trimBST(root, L, R);

		String out = treeNodeToString(ret);
		System.out.println(out);
	}
}
