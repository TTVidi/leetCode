package com.vidi.demo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/1/28 15:17
 * @Descripton :
 * <p>
 * Binary Tree Tilt
 * <p>
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the
 * sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
public class SolutionNo563 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int findTilt(TreeNode root) {
		if (root != null) {
			return findTilt(root.left) + findTilt(root.right) + Math.abs(sumTree(root.left) - sumTree(root.right));
		}
		return 0;
	}

	int sumTree(TreeNode node) {
		if (node != null) {
			return node.val + sumTree(node.left) + sumTree(node.right);
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
		TreeNode root = stringToTreeNode("[1,2,3,4,5,6,7]");
		int ret = new SolutionNo563().findTilt(root);
		String out = String.valueOf(ret);
		System.out.print(out);
	}
}
