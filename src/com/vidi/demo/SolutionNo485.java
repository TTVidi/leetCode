package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/27 9:33
 * @Descripton :
 * <p>
 * Max Consecutive Ones
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class SolutionNo485 {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int index = 0;
		for (int num : nums) {
			if (num == 1) {
				index++;
			} else {
				result = result >= index ? result : index;
				index = 0;
			}
		}
		result = result >= index ? result : index;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
	}
}
