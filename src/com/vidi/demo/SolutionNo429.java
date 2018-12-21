package com.vidi.demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2018/12/21 16:35
 * @Descripton :
 * <p>
 * N-ary Tree Level Order Traversal
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by
 * level).
 */
public class SolutionNo429 {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> results = new ArrayList<>();
		if (root != null) {
			Queue<Node> queue = new ArrayDeque<>();
			queue.add(root);
			List<Integer> temp = new ArrayList<>();
			List<Node> levelChildren = new ArrayList<>();
			while (!queue.isEmpty()) {
				while (!queue.isEmpty()) {
					Node current = queue.poll();
					temp.add(current.val);
					if (current.children != null) {
						levelChildren.addAll(current.children);
					}
				}
				results.add(temp);
				temp = new ArrayList<>();
				queue.addAll(levelChildren);
				levelChildren = new ArrayList<>();
			}
		}
		return results;
	}

}
