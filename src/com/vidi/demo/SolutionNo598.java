package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 11:05
 * @Descripton :
 * <p>
 * Range Addition II
 * <p>
 * Given an m * n matrix M initialized with all 0's and several update operations.
 * <p>
 * Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a
 * and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 * <p>
 * You need to count and return the number of maximum integers in the matrix after performing all the operations.
 */
public class SolutionNo598 {
	public int maxCount(int m, int n, int[][] ops) {
		int xmin = m;
		int ymin = n;
		for (int[] op : ops) {
			xmin = Math.min(xmin, op[0]);
			ymin = Math.min(ymin, op[1]);
		}
		return xmin * ymin;
	}
}
