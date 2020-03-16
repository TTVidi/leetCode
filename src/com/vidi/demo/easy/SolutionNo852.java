package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/27 9:23
 * @Descripton :
 * <p>
 * Peak Index in a Mountain Array
 * <p>
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... >
 * A[A.length - 1] Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i]
 * > A[i+1] > ... > A[A.length - 1].
 */
public class SolutionNo852 {
	public static int peakIndexInMountainArray(int[] A) {
		if (A.length >= 3) {
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] > A[i + 1]) {
					return i;
				}
			}
			return A.length - 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] A = new int[]{0, 2, 1, 0};
		System.out.println(peakIndexInMountainArray(A));
	}
}
