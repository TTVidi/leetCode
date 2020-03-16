package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/8/15 16:06
 * @Descripton :In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell; the value 1 representing a fresh orange; the value 2 representing a rotten
 * orange. Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible,
 * return -1 instead.
 */
public class SolutionNo994 {
	public int orangesRotting(int[][] grid) {
		int initial = 0;
		int zeroCount = 0;
		for (int[] ints : grid) {
			for (int anInt : ints) {
				if (anInt == 2) {
					initial++;
					zeroCount++;
				}
			}
		}
		int count = initial;
		int index = 0;
		do {
			initial = count;
			count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {

				}
			}
			index++;
		} while (count != initial);
		if (zeroCount + count == grid.length * grid.length) {
			return index - 1;
		}
		return -1;
	}
}
