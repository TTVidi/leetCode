package com.vidi.demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2018/11/29 7:52
 * @Descripton :
 * <p>
 * Maximum Depth of N-ary Tree
 * <p>
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * We should return its max depth, which is 3.
 */
public class SolutionNo559 {
	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	static int max = 0;
	static int depth = 0;

	public static int maxDepth(Node root) {
		if (root != null) {
			depth++;
			if (depth > max) {
				max = depth;
			}
			if (root.children != null && root.children.size() > 0) {
				for (Node child : root.children) {
					maxDepth(child);
					depth--;
				}
			}
		}
		return max;
	}

	public static int maxDepth2(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		int depth = queue.size();
		if (root != null) {
			queue.offer(root);
			while (!queue.isEmpty()) {
				int index = queue.size();
				for (int i = 0; i < index; i++) {
					Node node = queue.poll();
					if (node.children != null && node.children.size() > 0) {
						for (Node child : node.children) {
							queue.offer(child);
						}
					}
				}
				depth++;
			}
		}
		return depth;
	}

	public static void main(String[] args) {
		Node floorTwoFirst = new Node(5, null);
		Node floorTwoSecond = new Node(6, null);
		List<Node> floorTwo = new ArrayList<>();
		floorTwo.add(floorTwoFirst);
		floorTwo.add(floorTwoSecond);

		Node floorOneFirst = new Node(3, floorTwo);
		Node floorOneSecond = new Node(2, null);
		Node floorOneThird = new Node(4, null);
		List<Node> floorOne = new ArrayList<>();
		floorOne.add(floorOneFirst);
		floorOne.add(floorOneSecond);
		floorOne.add(floorOneThird);
		Node root = new Node(1, floorOne);
		System.out.println(maxDepth2(root));

	}
}
