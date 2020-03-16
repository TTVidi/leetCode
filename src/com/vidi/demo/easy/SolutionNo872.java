package com.vidi.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2018/12/3 15:10
 * @Descripton :
 * <p>
 * Leaf-Similar Trees
 * <p>
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value
 * sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class SolutionNo872 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> r1 = new ArrayList<>();
		findLeaf(root1, r1);
		List<Integer> r2 = new ArrayList<>();
		findLeaf(root2, r2);
		boolean rt = true;
		if (r1.size() == r2.size()) {
			for (int i = 0; i < r1.size(); i++) {
				if (r1.get(i).intValue() != r2.get(i).intValue()) {
					rt = false;
				}
			}
		} else {
			rt = false;
		}
		return rt;
	}

	public static void findLeaf(TreeNode node, List<Integer> results) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			results.add(node.val);
			return;
		}
		if (node.left != null) {
			findLeaf(node.left, results);
		}
		if (node.right != null) {
			findLeaf(node.right, results);
		}
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
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
			if (!"null".equals(item)) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!"null".equals(item)) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		String s1 = "119,113,null,11,30,43,76,15,60,67,74";
		String s2 = "11,69,60,115,66,15,60,67,74,null,76";
		TreeNode root1 = stringToTreeNode(s1);
		TreeNode root2 = stringToTreeNode(s2);

		boolean ret = leafSimilar(root1, root2);

		String out = booleanToString(ret);

		System.out.print(out);
	}
}
