package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/2/12 15:33
 * @Descripton :
 * <p>
 * Add to Array-Form of Integer
 * <p>
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if
 * X = 1231, then the array form is [1,2,3,1].
 * <p>
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 */
public class SolutionNo989 {
	public static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> result = new ArrayList<>(A.length);
		for (int i = A.length - 1; i >= 0; i--) {
			A[i] += K;
			if (A[i] > 9) {
				A[i] = A[i] % 10;
			}
			K = A[i] / 10;
			result.add(i, A[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> list = addToArrayForm(new int[]{1, 2, 0, 0}, 34);
		for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}
