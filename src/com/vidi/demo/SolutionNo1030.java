package com.vidi.demo;

import java.util.Arrays;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 16:39
 * @Descripton : We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r
 * < R and 0 <= c < C.
 * <p>
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 * <p>
 * Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to
 * largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| +
 * |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
 */
public class SolutionNo1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] res = new int[R*C][2];
		int idx = 0;
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				res[idx][0] = i;
				res[idx][1] = j;
				idx++;
			}
		}

		Arrays.sort(res,(o1, o2)->
				Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0) - (Math.abs(o2[0]-r0) + Math.abs(o2[1]-c0))
		);

		return res;
	}

	public static void main(String[] args) {
	}
}
