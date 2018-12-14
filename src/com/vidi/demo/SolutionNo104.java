package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2018/12/14 15:35
 * @Descripton :
 * <p>
 * Maximum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class SolutionNo104 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int depth = 1;
	int max = 0;

	public int maxDepth(TreeNode root) {
		if (root != null) {
			maximumDepth(root);
			return max;
		}
		return 0;
	}

	public void maximumDepth(TreeNode root) {
		if (root.left != null) {
			depth++;
			maximumDepth(root.left);
			depth--;
		}
		if (root.right != null) {
			depth++;
			maximumDepth(root.right);
			depth--;
		}
		if (root.left == null && root.right == null) {
			max = max > depth ? max : depth;
			return;
		}
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
		TreeNode root = stringToTreeNode("[3,9,20,null,null,15,7]");

		int ret = new SolutionNo104().maxDepth(root);

		String out = String.valueOf(ret);

		System.out.print(out);
	}
}
