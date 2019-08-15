package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/14 11:08
 * @Descripton :
 * <p>
 * Minimum Moves to Equal Array Elements
 * <p>
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
 * equal, where a move is incrementing n - 1 elements by 1.
 */
public class SolutionNo453 {
//	public static int minMoves(int[] nums) {
//		if (nums != null && nums.length > 0) {
//			if (nums.length == 1) {
//				return 0;
//			}
//			if (nums.length == 2) {
//				return nums[1] - nums[0] >= 0 ? nums[1] - nums[0] : nums[0] - nums[1];
//			}
//			long max = Integer.MIN_VALUE;
//			long sum = 0;
//			for (int num : nums) {
//				if (num > max) {
//					max = num;
//				}
//				sum += num;
//			}
//			int n = nums.length;
//			while (true) {
//				if ((n * max - sum) % (n - 1) == 0) {
//					long ss = (long) (((long) (n * max - sum)) / (n - 1));
//					return (int)ss;
//				}
//				max++;
//			}
//		}
//		return 0;
//	}

	public static int minMoves2(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num < min) {
				min = num;
			}
		}
		int ans = 0;
		for (int num : nums) {
			ans += num - min;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(minMoves2(new int[]{-100, 0, 100}));
	}
}
