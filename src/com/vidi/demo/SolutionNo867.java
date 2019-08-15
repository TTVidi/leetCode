package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/28 16:52
 * @Descripton :
 * <p>
 * Transpose Matrix
 * <p>
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the
 * matrix.
 */
public class SolutionNo867 {
	public static int[][] transpose(int[][] A) {
		int[][] B = null;
		if (A != null) {
			B = new int[A[0].length][A.length];
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[i].length; j++) {
					B[j][i] = A[i][j];
				}
			}
		}
		return B;
	}

	public static void main(String[] args) {
		int[][] transpose = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		for (int[] ints : transpose) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}
	}
}
