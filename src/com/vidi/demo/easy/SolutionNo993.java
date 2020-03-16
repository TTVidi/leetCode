package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/7/29 15:58
 * @Descripton : In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the
 * tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
public class SolutionNo993 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		int[] xArr = findNode(root, x, 0);
		int[] yArr = findNode(root, y, 0);
		if (xArr != null && yArr != null) {
			return xArr[1] == yArr[1] && xArr[0] != yArr[0];
		}
		return false;
	}

	public int[] findNode(TreeNode node, int value, int depth) {
		if (node != null) {
			if (node.left != null) {
				if (node.left.val == value) {
					int[] result = new int[2];
					result[0] = node.val;
					result[1] = depth + 1;
					return result;
				}
			}
			if (node.right != null) {
				if (node.right.val == value) {
					int[] result = new int[2];
					result[0] = node.val;
					result[1] = depth + 1;
					return result;
				}
			}
			int[] left = findNode(node.left, value, depth + 1);
			if (left == null) {
				return findNode(node.right, value, depth + 1);
			} else {
				return left;
			}
		}
		return null;
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
		TreeNode root = stringToTreeNode("[1,2,3,null,4,null,5]");
		int x = 5;
		int y = 4;

		boolean ret = new SolutionNo993().isCousins(root, x, y);

		String out = booleanToString(ret);

		System.out.print(out);
	}
}
