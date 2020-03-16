package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/19 17:08
 * @Descripton : Given an array A of integers, return true if and only if we can partition the array into three
 * non-empty parts with equal sums.
 * <p>
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2]
 * + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 */
public class SolutionNo1013 {
	public boolean canThreePartsEqualSum(int[] A) {
		int sum = 0;
		for (int i : A) {
			sum += i;
		}
		if (sum % 3 == 0) {
			sum /= 3;
			int temp = 0;
			int cout = 0;
			for (int i : A) {
				temp += i;
				if (temp == sum) {
					temp = 0;
					cout++;
				}
			}
			return temp == 0 && cout == 3;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new SolutionNo1013().canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
	}
}
