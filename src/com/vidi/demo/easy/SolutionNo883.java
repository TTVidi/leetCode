package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/27 11:31
 * @Descripton :
 * <p>
 * Projection Area of 3D Shapes
 * <p>
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * <p>
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 * <p>
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * <p>
 * Return the total area of all three projections.
 */
public class SolutionNo883 {
	public static int projectionArea(int[][] grid) {
		int topCount = 0;
		int leftCount = 0;
		int max;
		for (int i = 0; i < grid.length; i++) {
			max = grid[i][0];
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] > 0) {
					topCount++;
				}
				if (grid[i][j] > max) {
					max = grid[i][j];
				}
			}
			leftCount += max;
		}

		for (int i = 0; i < grid[0].length; i++) {
			max = grid[0][i];
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] > max) {
					max = grid[j][i];
				}
			}
			leftCount += max;
		}
		leftCount += topCount;
		return leftCount;
	}

	public static void main(String[] args) {
		int[][] s = new int[][]{{1, 2}, {3, 4}};
		int[][] s1 = new int[][]{{2}};
		System.out.println(projectionArea(s));
	}
}
