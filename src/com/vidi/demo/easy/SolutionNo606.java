package com.vidi.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 11:34
 * @Descripton :
 * <p>
 * Construct String from Binary Tree
 * <p>
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing
 * way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis
 * pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 */
public class SolutionNo606 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	StringBuilder sb = new StringBuilder();

	public String tree2str(TreeNode t) {
		if (t != null) {
			sb.append(t.val);
			if (t.left == null && t.right == null) {
				return sb.toString();
			} else {
				sb.append("(");
				tree2str(t.left);
				sb.append(")");
				if (t.right != null) {
					sb.append("(");
					tree2str(t.right);
					sb.append(")");
				}
			}
		}
		return sb.toString();
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
		TreeNode root = stringToTreeNode("[1,2,3,null,4]");
		String ret = new SolutionNo606().tree2str(root);
		System.out.println(new SolutionNo606().tree2str(stringToTreeNode("[1,2,3,4]")));
		System.out.print(ret);
	}
}
