package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * N-ary Tree Preorder Traversal
 * <p>
 * iven an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 */
public class SolutionNo589 {
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

	public List<Integer> preorder(Node root) {
		if (root == null) {
			return results;
		}
		results.add(root.val);
		if (root.children != null) {
			for (Node child : root.children) {
				preorder(child);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		SolutionNo589 solution = new SolutionNo589();

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
		List<Integer> postorder = solution.preorder(root);
		for (Integer integer : postorder) {
			System.out.println(integer);
		}
	}
}
