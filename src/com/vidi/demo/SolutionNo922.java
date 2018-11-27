package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/27 10:47
 * @Descripton :
 * <p>
 * Sort Array By Parity II
 * <p>
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * <p>
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * <p>
 * You may return any answer array that satisfies this condition.
 */
public class SolutionNo922 {
	public static int[] sortArrayByParityII(int[] A) {
		int[] results = new int[A.length];
		int oddIndex = 1;
		int evenIndex = 0;
		for (int i : A) {
			if (i % 2 == 0) {
				results[evenIndex] = i;
				evenIndex += 2;
			} else {
				results[oddIndex] = i;
				oddIndex += 2;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] a = new int[]{4, 2, 5, 7, 1, 6, 8, 10, 11, 9};
		int[] array = sortArrayByParityII(a);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
