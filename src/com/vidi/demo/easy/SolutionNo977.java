package com.vidi.demo;

import java.util.Arrays;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 8:52
 * @Descripton :
 * <p>
 * Squares of a Sorted Array
 * <p>
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in
 * sorted non-decreasing order.
 */
public class SolutionNo977 {
	public static int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = (int) Math.pow(A[i], 2);
		}
		Arrays.sort(A);
		return A;
	}

	public static int[] sortedSquares2(int[] A) {
		int[] results = new int[A.length];
		int left = 0;
		int right = A.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (Math.abs(A[left]) >= Math.abs(A[right])) {
				results[i] = A[left] * A[left++];
			} else {
				results[i] = A[right] * A[right--];
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] ints = sortedSquares2(new int[]{-4, -1, 0, 3, 10});
//		for (int anInt : ints) {
//			System.out.println(anInt);
//		}
	}
}
