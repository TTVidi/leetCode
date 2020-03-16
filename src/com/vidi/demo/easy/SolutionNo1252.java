package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/26 14:59
 * @Descripton : Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices
 * where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 * <p>
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 */
public class SolutionNo1252 {
	public int oddCells(int n, int m, int[][] indices) {
		int[] an = new int[n];
		int[] am = new int[m];
		for (int[] index : indices) {
			an[index[0]] ^= 1;
			am[index[1]] ^= 1;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				count += ((an[i] + am[j]) % 2);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(1 ^ 1);
		System.out.println(0 ^ 1);
	}
}
