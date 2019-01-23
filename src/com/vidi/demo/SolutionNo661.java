package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 16:29
 * @Descripton :
 * <p>
 * Image Smoother
 * <p>
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
 * scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 */
public class SolutionNo661 {
	public int[][] imageSmoother(int[][] M) {
		int[][] result = new int[M.length][M[0].length];
		int row = M.length, col = M[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int num = 1, val = M[i][j];
				if (i > 0) {++num; val += M[i-1][j];}
				if (i < row-1) {++num; val += M[i+1][j];}
				if (j > 0) {++num; val += M[i][j-1];}
				if (j < col-1) {++num; val += M[i][j+1];}
				if (i > 0 && j > 0) {++num; val += M[i-1][j-1];}
				if (i > 0 && j < col-1) {++num; val += M[i-1][j+1];}
				if (i < row-1 && j > 0) {++num; val += M[i+1][j-1];}
				if (i < row-1 && j < col-1) {++num; val += M[i+1][j+1];}
				result[i][j] = val / num;
			}
		}

		return result;
	}
}
