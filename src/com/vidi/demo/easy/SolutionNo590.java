package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * N-ary Tree Postorder Traversal
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its postorder traversal as: [5,6,3,2,4,1].
 */
public class SolutionNo590 {
	// Definition for a Node.
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

	List<Integer> results = new ArrayList<>();

	public List<Integer> postorder(Node root) {
		if (root == null) {
			return results;
		}
		if (root.children == null) {
			results.add(root.val);
		} else {
			for (Node child : root.children) {
				postorder(child);
			}
			results.add(root.val);
		}
		return results;
	}

	public static void main(String[] args) {
		SolutionNo590 solution = new SolutionNo590();

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
		List<Integer> postorder = solution.postorder(root);
		for (Integer integer : postorder) {
			System.out.println(integer);
		}
	}
}
