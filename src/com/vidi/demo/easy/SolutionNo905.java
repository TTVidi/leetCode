package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/11/26 15:27
 * @Descripton :
 * <p>
 * Sort Array By Parity
 * <p>
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all
 * the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 */
public class SolutionNo905 {

	public static int[] sortArrayByParity(int[] A) {

		List<Integer> evens = new ArrayList<>();
		List<Integer> odds = new ArrayList<>();
		for (int i : A) {
			if (i % 2 == 0) {
				evens.add(i);
			} else {
				odds.add(i);
			}
		}
		evens.addAll(odds);
		int[] results = new int[evens.size()];
		for (int i = 0; i < evens.size(); i++) {
			results[i] = evens.get(i);
		}
		return results;
	}

	public static void main(String[] args) {
		int[] A = new int[]{3, 1, 2, 4};
		int[] parity = sortArrayByParity(A);
		for (int i : parity) {
			System.out.println(i);
		}
	}
}
