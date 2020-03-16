package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/4 9:38
 * @Descripton :
 * <p>
 * Toeplitz Matrix
 * <p>
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */
public class SolutionNo766 {
	public static boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (i == 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					int baseI = 0;
					int baseJ = j;
					while (++baseI < matrix.length && ++baseJ < matrix[0].length) {
						if (matrix[baseI][baseJ] != matrix[0][j]) {
							return false;
						}
					}
				}
			} else {
				int baseI = i;
				int baseJ = 0;
				while (++baseI < matrix.length && ++baseJ < matrix[i].length) {
					if (matrix[baseI][baseJ] != matrix[i][0]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
		System.out.println(isToeplitzMatrix(matrix));
	}
}
