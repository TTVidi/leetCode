package com.vidi.demo;

import javax.xml.ws.soap.Addressing;
import java.util.*;

/**
 * @Author : Vidi
 * @Date : 2019/1/31 14:08
 * @Descripton :
 * <p>
 * Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 * <p>
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9  20 /  \ 15   7 return its bottom-up level order
 * traversal as: [ [15,7], [9,20], [3] ]
 */
public class SolutionNo107 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<Integer> temp = new ArrayList<>();
		Queue<TreeNode> current = new ArrayDeque<>();
		Queue<TreeNode> next = new ArrayDeque<>();
		current.add(root);
		while (!current.isEmpty()) {
			TreeNode node = current.poll();
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			temp.add(node.val);
			if (current.isEmpty() && !next.isEmpty()) {
				current = next;
				/**
				 * do not use next.clear()
				 */
				next = new ArrayDeque<>();
				result.add(0, temp);
				/**
				 * do not use next.clear()
				 */
				temp = new ArrayList<>();
			}
		}
		result.add(0, temp);
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

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static String int2dListToString(List<List<Integer>> nums) {
		StringBuilder sb = new StringBuilder("[");
		for (List<Integer> list : nums) {
			sb.append(integerArrayListToString(list));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) {
		TreeNode root = stringToTreeNode("[3,9,20,null,null,15,7]");

		List<List<Integer>> ret = new SolutionNo107().levelOrderBottom(root);

		String out = int2dListToString(ret);

		System.out.print(out);
	}
}
