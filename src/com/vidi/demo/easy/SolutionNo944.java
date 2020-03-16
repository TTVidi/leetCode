package com.vidi.demo;

import java.util.HashSet;

/**
 * @Author : Vidi
 * @Date : 2018/11/26 14:15
 * @Descripton :
 * <p>
 * Delete Columns to Make Sorted
 * <p>
 * We are given an array A of N lowercase letter strings, all of the same length.
 * <p>
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 * The remaining rows of strings form columns when read north to south.
 * <p>
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after
 * deletions is ["bef","vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the
 * c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 * <p>
 * Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in
 * non-decreasing sorted order.
 * <p>
 * Return the minimum possible value of D.length.
 */
public class SolutionNo944 {
	public static int minDeletionSize(String[] A) {
		HashSet<Integer> distinct = new HashSet<>();
		for (int i = 0; i < A.length - 1; i++) {
			String current = A[i];
			String next = A[i + 1];
			for (int j = 0; j < current.length(); j++) {
				if (current.charAt(j) > next.charAt(j)) {
					distinct.add(j);
				}
			}
		}
		return distinct.size();
	}

	public static void main(String[] args) {
		String[] A = new String[]{"egguij", "gjsnnk", "lstgon", "ztzrqv"};
		System.out.println(minDeletionSize(A));
	}
}
