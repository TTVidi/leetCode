package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/1/16 10:39
 * @Descripton :
 * <p>
 * Sum of Left Leaves
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 */
public class SolutionNo404 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root != null) {
			if (root.left != null && root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			}
			if (root.left != null) {
				sumOfLeftLeaves(root.left);
			}
			if (root.right != null) {
				sumOfLeftLeaves(root.right);
			}
		}
		return sum;
	}

	public int sumOfLeftLeaves2(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.left != null && node.left.left == null && node.left.right == null) {
					sum += node.left.val;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return sum;
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
		TreeNode root = stringToTreeNode("[3,9,20,10,11,15,7,null,null,12]");

		int ret = new SolutionNo404().sumOfLeftLeaves2(root);

		String out = String.valueOf(ret);

		System.out.print(out);
	}
}
