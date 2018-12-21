package com.vidi.demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2018/12/21 17:11
 * @Descripton :
 * <p>
 * Average of Levels in Binary Tree
 * <p>
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 */
public class SolutionNo637 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		List<Double> results = new ArrayList<>();
		queue.add(root);
		int count = 0;
		double sum = 0;
		List<TreeNode> levelChildren = new ArrayList<>();
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					levelChildren.add(node.left);
				}
				if (node.right != null) {
					levelChildren.add(node.right);
				}
				sum += node.val;
				count++;
			}
			queue.addAll(levelChildren);
			results.add(sum / count);
			sum = 0;
			count = 0;
			levelChildren = new ArrayList<>();
		}
		return results;
	}
}
