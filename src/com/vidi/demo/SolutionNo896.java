package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/26 14:50
 * @Descripton :
 * <p>
 * Monotonic Array
 * <p>
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <=
 * j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 */
public class SolutionNo896 {
	public static boolean isMonotonic(int[] A) {
		if (A == null || A.length <= 2) {
			return true;
		}
		boolean isIncrease = A[A.length - 1] >= A[0];
		for (int i = 1; i < A.length; i++) {
			if (isIncrease && (A[i] < A[i - 1])) {
				return false;
			}
			if (!isIncrease && (A[i] > A[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMonotonic(new int[]{1,2,2,3}));
	}
}
