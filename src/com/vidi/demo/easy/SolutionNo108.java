package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/1/16 11:06
 * @Descripton :
 * <p>
 * Convert Sorted Array to Binary Search Tree
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 */
public class SolutionNo108 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode node = null;
		if (nums != null && nums.length > 0) {
			node = new TreeNode(-1);
			createTree(node, nums, 0, nums.length - 1);
		}
		return node;
	}

	public void createTree(TreeNode node, int[] nums, int begin, int end) {
		int middle = (begin + end) >> 1;
		node.val = nums[middle];
		if (begin != end) {
			if (begin < middle) {
				TreeNode left = new TreeNode(-1);
				node.left = left;
				createTree(left, nums, begin, middle - 1);
			}
			if (end > middle) {
				TreeNode right = new TreeNode(-1);
				node.right = right;
				createTree(right, nums, middle + 1, end);
			}
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
		TreeNode treeNode = new SolutionNo108().sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
		System.out.println(1);
	}
}
