package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/14 9:33
 * @Descripton :
 * <p>
 * Reshape the Matrix
 * <p>
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
 * size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row
 * number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order
 * as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 */
public class SolutionNo566 {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums.length * nums[0].length == r * c) {
			int[][] results = new int[r][c];
			int index = 0;
//			for (int[] num : nums) {
//				for (int i : num) {
//					results[index / c][index % c] = i;
//					index++;
//				}
//			}
			for (int i=0;i<r*c;i++)
				results[i/c][i%c] = nums[i/nums.length][i%nums.length];
			return results;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[][] matrixReshape = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
		System.out.println(1);
	}
}
