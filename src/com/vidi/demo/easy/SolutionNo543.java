package com.vidi.demo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/1/29 15:29
 * @Descripton :
 * <p>
 * Diameter of Binary Tree
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the
 * length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 */
public class SolutionNo543 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int maxPath = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		findPathLength(root);
		return maxPath;
	}

	public int findPathLength(TreeNode node) {
		if (node != null) {
			int left = findPathLength(node.left);
			int right = findPathLength(node.right);
			maxPath = Math.max(maxPath, left + right);
			return 1 + Math.max(left, right);
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

	public static void main(String[] args) throws IOException {
		TreeNode root = stringToTreeNode("[1,2,3,4,5,null,null,6,7,8,9,null,null,null,null,10,11,12,13,14,15]");
		int ret = new SolutionNo543().diameterOfBinaryTree(root);
		String out = String.valueOf(ret);
		System.err.print(out);
	}
}
