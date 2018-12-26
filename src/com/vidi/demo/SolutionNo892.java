package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/26 14:20
 * @Descripton :
 * <p>
 * Surface Area of 3D Shapes
 * <p>
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Return the total surface area of the resulting shapes.
 */
public class SolutionNo892 {
	public static int surfaceArea(int[][] grid) {
		int total = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] > 0) {
					total += (4 * grid[i][j] + 2);
					if (i > 0) {
						total -= grid[i - 1][j] < grid[i][j] ? grid[i - 1][j] : grid[i][j];
					}
					if (i < grid.length - 1) {
						total -= grid[i + 1][j] < grid[i][j] ? grid[i + 1][j] : grid[i][j];
					}
					if (j > 0) {
						total -= grid[i][j - 1] < grid[i][j] ? grid[i][j - 1] : grid[i][j];
					}
					if (j < grid[i].length - 1) {
						total -= grid[i][j + 1] < grid[i][j] ? grid[i][j + 1] : grid[i][j];
					}
				}
			}
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
	}
}
