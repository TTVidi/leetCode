package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/4 11:20
 * @Descripton :
 * <p>
 * Island Perimeter
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and
 * there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a
 * square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the
 * island.
 */
public class SolutionNo463 {
	public static int islandPerimeter(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					if (i == 0) {
						result++;
					} else {
						if (grid[i - 1][j] == 0) {
							result++;
						}
					}

					if (i == grid.length - 1) {
						result++;
					} else {
						if (grid[i + 1][j] == 0) {
							result++;
						}
					}

					if (j == 0) {
						result++;
					} else {
						if (grid[i][j - 1] == 0) {
							result++;
						}
					}

					if (j == grid[i].length - 1) {
						result++;
					} else {
						if (grid[i][j + 1] == 0) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
		System.out.println(islandPerimeter(grid));
	}
}
