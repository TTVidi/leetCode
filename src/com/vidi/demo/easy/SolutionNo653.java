package com.vidi.demo;

import java.util.*;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 8:42
 * @Descripton :
 * <p>
 * Two Sum IV - Input is a BST
 * <p>
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their
 * sum is equal to the given target.
 */
public class SolutionNo653 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean findTarget(TreeNode root, int k) {
		if (root != null) {
			List<Integer> list = new ArrayList<>();
			recursive(list, root);
			int index = list.get(0);
			int[] temp = new int[list.get(list.size() - 1) - index + 1];
			for (Integer integer : list) {
				temp[integer - index] = 1;
			}

			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == 1) {
					int remain = k - (i + index);
					remain -= index;
					if (remain > i && remain < temp.length - 1 && temp[remain] == 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean findTarget2(TreeNode root, int k) {
		if (root != null) {
			Set<Integer> set = new HashSet<>();
			recursive2(set, root);
			for (Integer integer : set) {
				if (set.contains(k - integer) && k - integer != integer) {
					return true;
				}
			}
		}
		return false;
	}

	public void recursive2(Set<Integer> set, TreeNode root) {
		if (root.left != null) {
			recursive2(set, root.left);
		}
		set.add(root.val);
		if (root.right != null) {
			recursive2(set, root.right);
		}
	}

	public void recursive(List<Integer> queue, TreeNode root) {
		if (root.left != null) {
			recursive(queue, root.left);
		}
		queue.add(root.val);
		if (root.right != null) {
			recursive(queue, root.right);
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

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) {
		TreeNode root = stringToTreeNode("[2,null,3]");
		int k = Integer.parseInt("6");

		boolean ret = new SolutionNo653().findTarget(root, k);

		String out = booleanToString(ret);

		System.out.print(out);
	}
}
