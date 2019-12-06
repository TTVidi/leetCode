package com.vidi.demo.medium;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/12/6 10:07
 * @Descripton :
 */
public class SolutionNo988 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	StringBuilder result;

	public String smallestFromLeaf(TreeNode root) {
		smallestFromLeaf1(root, new StringBuilder());
		return result.toString();
	}

	private void smallestFromLeaf1(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		sb.insert(0, (char) ('a' + root.val));
		if (root.left == null && root.right == null) {
			if (result == null) {
				result = sb;
			} else {
				result = compare(sb, result);
			}
		} else {
			StringBuilder temp = new StringBuilder(sb);
			if (root.left != null) {
				smallestFromLeaf1(root.left, sb);
				sb = temp;
			}
			if (root.right != null) {
				smallestFromLeaf1(root.right, sb);
			}
		}
	}

	private StringBuilder compare(StringBuilder s1, StringBuilder s2) {
		int index = 0;
		char[] charArray1 = s1.toString().toCharArray();
		char[] charArray2 = s2.toString().toCharArray();
		while (index < charArray1.length && index < charArray2.length) {
			if (charArray1[index] < charArray2[index]) {
				return s1;
			}
			if (charArray2[index] < charArray1[index]) {
				return s2;
			}
			index++;
		}
		if (s1.length() <= s2.length()) {
			return s1;
		} else {
			return s2;
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

	public static void main(String[] args) throws IOException {
		TreeNode root = stringToTreeNode("[2,2,1,null,1,0,null,0]");
		String ret = new SolutionNo988().smallestFromLeaf(root);
		System.out.print(ret);
	}
}
