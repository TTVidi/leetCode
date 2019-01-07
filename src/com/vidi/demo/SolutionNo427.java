package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/29 11:37
 * @Descripton :
 * <p>
 * Construct Quad Tree <p>We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be
 * true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes
 * until the values in the region it represents are all the same.
 * <p>
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node.
 * The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem
 * better:
 * <p>
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 * <p>
 * <p>
 * <p>
 * It can be divided according to the definition above:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 * <p>
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 */
public class SolutionNo427 {
	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
		}

		public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	}


	public Node construct(int[][] grid) {
		Node result = new Node();
		iterator(grid, result);
		return fun(grid, 0, grid.length, 0, grid.length);
//		return result;
	}

	public Node fun(int[][] grid, int left, int right, int top, int bottom) {
		Node root = null;
		int key = grid[top][left];
		for (int i = top; i < bottom; i++) {
			for (int j = left; j < right; j++) {
				if (grid[i][j] != key) {
					Node topLeft = fun(grid, left, (left + right) / 2, top, (top + bottom) / 2);
					Node topRight = fun(grid, (left + right) / 2, right, top, (top + bottom) / 2);
					Node bottomLeft = fun(grid, left, (left + right) / 2, (top + bottom) / 2, bottom);
					Node bottomRight = fun(grid, (left + right) / 2, right, (top + bottom) / 2, bottom);
					root = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
					return root;
				}
			}
		}
		root = new Node();
		root.val = key == 1 ? true : false;
		root.isLeaf = true;
		return root;
	}

	public void iterator(int[][] grid, Node node) {
		if (grid != null && node != null && grid.length >= 1) {
			node.val = grid[0][0] == 1;
			node.isLeaf = isSame(grid);
			Node topLeft = null;
			Node topRight = null;
			Node bottomLeft = null;
			Node bottomRight = null;
			if (!node.isLeaf) {
				int[][][] divideArray = divideArray(grid);
				topLeft = new Node();
				if (!topLeft.isLeaf) {
					iterator(divideArray[0], topLeft);
				}

				topRight = new Node();
				if (!topRight.isLeaf) {
					iterator(divideArray[1], topRight);
				}

				bottomLeft = new Node();
				if (!bottomLeft.isLeaf) {
					iterator(divideArray[2], bottomLeft);
				}

				bottomRight = new Node();
				if (!bottomRight.isLeaf) {
					iterator(divideArray[3], bottomRight);
				}
			}
			node.topLeft = topLeft;
			node.topRight = topRight;
			node.bottomLeft = bottomLeft;
			node.bottomRight = bottomRight;
		}
	}

	public boolean isSame(int[][] grid) {
		int pre = grid[0][0];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (pre != grid[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][][] divideArray(int[][] grid) {
		int length = grid.length;
		int half = length >> 1;
		int[][] topLeft = new int[half][half];
		int[][] topRight = new int[half][half];
		int[][] bottomLeft = new int[half][half];
		int[][] bottomRight = new int[half][half];

		for (int j = 0; j < half; j++) {
			for (int i = 0; i < half; i++) {
				topLeft[i][j] = grid[i][j];
			}
		}

		for (int j = 0; j < half; j++) {
			for (int i = half; i < length; i++) {
				topRight[i - half][j] = grid[i][j];
			}
		}

		for (int j = half; j < length; j++) {
			for (int i = 0; i < half; i++) {
				bottomLeft[i][j - half] = grid[i][j];
			}
		}

		for (int i = half; i < length; i++) {
			for (int j = half; j < length; j++) {
				bottomRight[i - half][j - half] = grid[i][j];
			}
		}
		return new int[][][]{topLeft, bottomLeft, topRight, bottomRight};
	}

	public static void main(String[] args) {
		int[][] grid = new int[][]{
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
		};
		SolutionNo427 solution = new SolutionNo427();
		Node node = solution.construct(grid);
		System.out.println(12);
	}

}

