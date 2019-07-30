package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/29 16:35
 * @Descripton : Given an array A of integers, we must modify the array in the following way: we choose an i and replace
 * A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 * <p>
 * Return the largest possible sum of the array after modifying it in this way.
 */
public class SolutionNo1005 {
	public int largestSumAfterKNegations(int[] A, int K) {
		int[] idx = new int[201];
		for (int i : A) {
			idx[i + 100]++;
		}
		int sum = 0;
		for (int i = 0; i < idx.length; i++) {
			if (idx[i] > 0) {
				if (K > 0) {
					if (i < 100) {
						if (idx[i] <= K) {
							K -= idx[i];
							idx[200 - i] += idx[i];
						} else {
							idx[200 - i] += K;
							sum += ((i - 100) * (idx[i] - K));
							K = 0;
						}
					} else {
						if (K % 2 == 0) {
							K = 0;
							sum += ((i - 100) * idx[i]);
						} else {
							K = 0;
							sum += (100 - i);
							sum += ((i - 100) * (idx[i] - 1));
						}
					}
				} else if (idx[i] > 0) {
					sum += (i - 100) * idx[i];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new SolutionNo1005().largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
	}
}
