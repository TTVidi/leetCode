package com.vidi.demo.hard;

/**
 * @Author : Vidi
 * @Date : 2019/12/6 10:52
 * @Descripton :Given an unsorted integer array, find the smallest missing positive integer.
 */
public class SolutionNo41 {
	public static int firstMissingPositive(int[] nums) {
		int N = nums.length;
		int upBound = N + 2;
		// constrain the range into [0, N+1]
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				nums[i] = 0;
			} else if (nums[i] > N + 1) {
				nums[i] = N + 1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int t = nums[i];
			if (t > 0 && t <= N && nums[t - 1] < upBound) {
				nums[t - 1] += upBound;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < upBound) {
				return i + 1;
			}
		}
		return N + 1;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9}));
	}
}
