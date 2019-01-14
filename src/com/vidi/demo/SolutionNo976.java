package com.vidi.demo;

import java.util.Arrays;

/**
 * @Author : Vidi
 * @Date : 2019/1/14 10:55
 * @Descripton :
 * <p>
 * Largest Perimeter Triangle
 * <p>
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of
 * these lengths.
 * <p>
 * If it is impossible to form any triangle of non-zero area, return 0.
 */
public class SolutionNo976 {
	public static int largestPerimeter(int[] A) {
		Arrays.sort(A);
		if (A.length >= 3) {
			for (int i = A.length - 1; i >= 2; i--) {
				if (A[i] < A[i - 1] + A[i - 2]) {
					return A[i] + A[i - 1] + A[i - 2];
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(largestPerimeter(new int[]{3, 6, 2, 3}));
	}
}
