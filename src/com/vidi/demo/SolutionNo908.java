package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/28 16:38
 * @Descripton :
 * <p>
 * Smallest Range I
 * <p>
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * <p>
 * After this process, we have some array B.
 * <p>
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 */
public class SolutionNo908 {
	public static int smallestRangeI(int[] A, int K) {
		int max = A[0];
		int min = A[0];
		for (int i : A) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		int result = max - min - 2 * K;
		return result > 0 ? result : 0;
	}

	public static void main(String[] args) {
		System.out.println(smallestRangeI(new int[]{1, 3, 6}, 3));
	}
}
