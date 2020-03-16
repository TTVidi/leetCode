package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/29 17:16
 * @Descripton :
 * <p>
 * Maximum Product of Three Numbers
 * <p>
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 */
public class SolutionNo628 {
	public static int maximumProduct(int[] nums) {
		if (nums.length > 3) {
			int min = Math.min(nums[0], nums[1]);
			int secondMin = nums[0] + nums[1] - min;
			int max = Integer.MIN_VALUE;
			int secondMax = max;
			int thirdMax = max;
			for (int num : nums) {
				if (num >= max) {
					thirdMax = secondMax;
					secondMax = max;
					max = num;
				} else if (num >= secondMax) {
					thirdMax = secondMax;
					secondMax = num;
				} else if (num > thirdMax) {
					thirdMax = num;
				} else if (num >= secondMin) {
					continue;
				} else if (num > min) {
					secondMin = num;
				} else {
					secondMin = min;
					min = num;
				}
			}
			if (secondMin < 0) {
				return Math.max(min * secondMin * max, max * secondMax * thirdMax);
			}
			return max * secondMax * thirdMax;
		}
		return nums[0] * nums[1] * nums[2];
	}

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[]{1, 2, 3, 4}));
	}
}
