package com.vidi.demo;

import java.lang.invoke.MutableCallSite;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/7/19 16:31
 * @Descripton :Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number
 * starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent
 * 01101 in binary, which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 */
public class SolutionNo1022 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	public int sumRootToLeaf(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode node, int sum) {
		if (node != null) {
			sum += node.val;
			int left = 0;
			int right = 0;
			if (node.left == null && node.right == null) {
				return sum;
			}
			if (node.left != null) {
				left = dfs(node.left, sum * 2);
			}
			if (node.right != null) {
				right = dfs(node.right, sum * 2);
			}
			return left + right;
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
		TreeNode root = stringToTreeNode("[1,0,1,0,1,0,1]");

		int ret = new SolutionNo1022().sumRootToLeaf(root);

		String out = String.valueOf(ret);

		System.out.print(out);
	}
}
