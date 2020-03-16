package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/27 10:23
 * @Descripton :
 * <p>
 * Move Zeroes
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 */
public class SolutionNo283 {
	public static void moveZeroes(int[] nums) {
		int zeroIndex = -1;
		int positiveIndex = 0;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				if (zeroIndex == -1) {
					zeroIndex = i;
				}
				i++;
			} else {
				positiveIndex = i++;
				if (positiveIndex > zeroIndex && zeroIndex >= 0) {
					int temp = nums[positiveIndex];
					nums[positiveIndex] = nums[zeroIndex];
					nums[zeroIndex] = temp;
					zeroIndex = (zeroIndex + 1) <= positiveIndex ? zeroIndex + 1 : positiveIndex;
				}
			}
		}
		for (int num : nums) {
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		moveZeroes(new int[]{0, 0, 1, 12, 0, 13, 14, 15, 0});

	}
}
