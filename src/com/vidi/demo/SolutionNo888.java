package com.vidi.demo;

import java.util.HashSet;

/**
 * @Author : Vidi
 * @Date : 2018/12/27 8:58
 * @Descripton :
 * <p>
 * Fair Candy Swap
 * <p>
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j]
 * is the size of the j-th bar of candy that Bob has.
 * <p>
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the
 * same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they
 * have.)
 * <p>
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the
 * size of the candy bar that Bob must exchange.
 * <p>
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 */
public class SolutionNo888 {
	public static int[] fairCandySwap(int[] A, int[] B) {
		int[] result = new int[2];
		int i = 0;
		int countA = 0;
		int countB = 0;
		for (; i < A.length && i < B.length; i++) {
			countA += A[i];
			countB += B[i];
		}
		if (i == A.length) {
			for (; i < B.length; i++) {
				countB += B[i];
			}
		} else {
			for (; i < A.length; i++) {
				countA += A[i];
			}
		}
		int count = (countA - countB) >> 1;
		for (int indexA : A) {
			for (int indexB : B) {
				if (indexA - indexB == count) {
					result[0] = indexA;
					result[1] = indexB;
					return result;
				}
			}
		}
		return null;
	}

	public static int[] fairCandySwap2(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		int[] result = new int[2];
		HashSet<Integer> set = new HashSet<>(B.length);
		for (int i : A) {
			sumA += i;
		}
		for (int i : B) {
			sumB += i;
			set.add(i);
		}
		int diff = (sumA - sumB) >> 1;
		for (int i : A) {
			if (set.contains(i - diff)) {
				result[0] = i;
				result[1] = i - diff;
				return result;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] ints = fairCandySwap2(new int[]{1, 1}, new int[]{2, 2});
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}
}
