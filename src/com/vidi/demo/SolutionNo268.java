package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/28 9:41
 * @Descripton :
 * <p>
 * Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the
 * array.
 */
public class SolutionNo268 {
	public int missingNumber(int[] nums) {
		int[] array = new int[nums.length + 1];
		for (int num : nums) {
			array[num] = 1;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				return i;
			}
		}
		return 0;
	}
}
